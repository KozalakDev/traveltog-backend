package koza.dev.traveltogbackend.controller.auth;

import koza.dev.traveltogbackend.exception.AlreadyExistsException;
import koza.dev.traveltogbackend.exception.handler.GenericException;
import koza.dev.traveltogbackend.model.Role;
import koza.dev.traveltogbackend.model.User;
import koza.dev.traveltogbackend.repository.UserRepository;
import koza.dev.traveltogbackend.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;
    public AuthenticationResponse register(RegisterRequest request) {
        var isAlreadyExists = existsUserByEmailAndUsername(request.getEmail(), request.getUsername());
        if (!existsUserByEmailAndUsername(request.getEmail(), request.getUsername())) {
            var user = User.builder()
                    .username(request.getUsername())
                    .email(request.getEmail())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .role(Role.USER)
                    .build();

            repository.save(user);
            var jwtToken = jwtService.generateToken(user);
            return AuthenticationResponse.builder()
                    .token(jwtToken)
                    .build();
        }else{
            throw new AlreadyExistsException(request.getUsername()+" or " +request.getEmail() +" already exists");
        }
    }
    public AuthenticationResponse authenticate(AuthenticationRequest request){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = repository.findUserByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public Boolean existsUserByEmailAndUsername(String email, String username){
        return repository.existsUserByEmailAndUsername(email,username);
    }

}
