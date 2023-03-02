package koza.dev.traveltogbackend.service;

import koza.dev.traveltogbackend.dto.TravellerDto;
import koza.dev.traveltogbackend.dto.converter.TravellerDtoConverter;
import koza.dev.traveltogbackend.dto.requests.CreateTravellerRequest;
import koza.dev.traveltogbackend.dto.requests.UpdateTravellerRequest;
import koza.dev.traveltogbackend.exception.AlreadyExistsException;
import koza.dev.traveltogbackend.exception.NotFoundException;
import koza.dev.traveltogbackend.model.Traveller;
import koza.dev.traveltogbackend.repository.TravellerRepository;
import koza.dev.traveltogbackend.service.abstracts.TravellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TravellerServiceImpl implements TravellerService {
    private final TravellerRepository repository;
    private final TravellerDtoConverter travellerDtoConverter;

    public Boolean existsTravellerByEmailAndUsername(String email, String username){
        return repository.existsTravellerByEmailAndUsername(email,username);
    }

    @Override
    public TravellerDto createTraveller(CreateTravellerRequest request) {
        if(!existsTravellerByEmailAndUsername(request.getEmail(), request.getUsername())){
            Traveller traveller = Traveller.builder()
                    .email(request.getEmail())
                    .password(request.getPassword())
                    .profileImage(request.getProfileImage())
                    .username(request.getUsername())
                    .UUID(request.getUuid())
                    .build();
            return travellerDtoConverter.convertTo(repository.save(traveller));
        }else{
            throw new AlreadyExistsException(request.getUsername()+" or " +request.getEmail() +" already exists");
        }
    }

    @Override
    public List<TravellerDto> getAll(){
        return repository.findAll()
                .stream()
                .map(travellerDtoConverter::convertTo)
                .collect(Collectors.toList());
    }

    @Override
    public TravellerDto getTravellerByUUID(String UUID){
        Traveller traveller = repository.findTravellerByUUID(UUID);
        if(traveller == null){
            throw new NotFoundException("not such found traveller");
        }else{
            return travellerDtoConverter.convertTo(traveller);
        }
    }

    @Override
    public Traveller findTravellerByUUID(String UUID){
        Traveller traveller = repository.findTravellerByUUID(UUID);
        if(traveller == null){
            throw new NotFoundException("not such found traveller");
        }else{
            return traveller;
        }
    }

    @Override
    @Modifying
    public TravellerDto updateTraveller(String UUID, UpdateTravellerRequest request){
        Traveller traveller = findTravellerByUUID(UUID);
        Traveller updatedTraveller = Traveller.builder()
                .username(request.getUsername())
                .profileImage(request.getProfileImage())
                .email(request.getEmail())
                .build();
        traveller.setUUID(traveller.getUUID());
        traveller.setPassword(traveller.getPassword());
        traveller.setUsername(updatedTraveller.getUsername());
        traveller.setProfileImage(updatedTraveller.getProfileImage());
        traveller.setEmail((updatedTraveller.getEmail()));

        return travellerDtoConverter.convertTo(repository.save(traveller));

    }



    @Override
    public void deleteTraveller(String UUID){
        Traveller traveller = repository.findTravellerByUUID(UUID);
        if(traveller == null){
            throw new NotFoundException("not such find a traveller");
        }else{
            repository.delete(traveller);

        }
    }



}
