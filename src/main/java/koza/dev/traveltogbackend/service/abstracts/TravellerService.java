package koza.dev.traveltogbackend.service.abstracts;

import koza.dev.traveltogbackend.dto.TravellerDto;
import koza.dev.traveltogbackend.dto.requests.CreateTravellerRequest;
import koza.dev.traveltogbackend.model.Traveller;

import javax.validation.groups.Default;
import java.util.List;

public interface TravellerService {

    TravellerDto createTraveller(CreateTravellerRequest request);

    List<TravellerDto> getAll();

    TravellerDto getTravellerById(int Id);

    Traveller findTravellerById(int id);

    TravellerDto updateTraveller(int Id, CreateTravellerRequest request);

    void deleteTraveller(int Id);
}
