package koza.dev.traveltogbackend.service;

import koza.dev.traveltogbackend.dto.CreateTravellerRequest;
import koza.dev.traveltogbackend.model.Traveller;
import koza.dev.traveltogbackend.repository.TravellerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TravellerServiceImpl {

    private final TravellerRepository repository;

    public Traveller createTraveller(CreateTravellerRequest request){

        Traveller traveller = Traveller.builder()
                .email(request.getEmail())
                .password(request.getPassword())
                .profileImage(request.getProfileImage())
                .username(request.getUsername())
                .build();
        repository.save(traveller);
        return traveller;
    }

    public List<Traveller> getTraveller(){

        return repository.findAll();
    }



}
