package koza.dev.traveltogbackend.service;

import koza.dev.traveltogbackend.dto.TravellerDto;
import koza.dev.traveltogbackend.dto.converter.TravellerDtoConverter;
import koza.dev.traveltogbackend.dto.requests.CreateTravellerRequest;
import koza.dev.traveltogbackend.exception.AlreadyExistsException;
import koza.dev.traveltogbackend.exception.NotFoundException;
import koza.dev.traveltogbackend.model.Traveller;
import koza.dev.traveltogbackend.repository.TravellerRepository;
import koza.dev.traveltogbackend.service.abstracts.TravellerService;
import lombok.RequiredArgsConstructor;
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
    public TravellerDto getTravellerById(int Id){
        Traveller traveller = repository.findById(Id);
        if(traveller == null){
            throw new NotFoundException("not such found anything");
        }else{
            return travellerDtoConverter.convertTo(traveller);

        }
    }
    @Override
    public Traveller findTravellerById(int Id){
        Traveller traveller = repository.findById(Id);
        if(traveller == null){
            throw new NotFoundException("not such found anything");
        }else{
            return traveller;

        }
    }

    @Override
    public TravellerDto updateTraveller(int Id, CreateTravellerRequest request){
        TravellerDto traveller = getTravellerById(Id);
        Traveller updatedTraveller = Traveller.builder()
                .email(traveller.getEmail())
                .username(request.getUsername())
                .profileImage(request.getProfileImage())
                .password(request.getPassword()).build();
        updatedTraveller.setId(traveller.getId());
        updatedTraveller.setPassword(updatedTraveller.getPassword());
        updatedTraveller.setUsername(updatedTraveller.getUsername());
        updatedTraveller.setProfileImage(updatedTraveller.getProfileImage());
        return travellerDtoConverter.convertTo(repository.save(updatedTraveller));

    }
    @Override
    public void deleteTraveller(int Id){
        Traveller traveller = repository.findById(Id);
        if(traveller == null){
            throw new NotFoundException("not such find a thing");
        }else{
            repository.delete(traveller);

        }
    }



}
