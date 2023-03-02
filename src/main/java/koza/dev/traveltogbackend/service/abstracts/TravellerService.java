package koza.dev.traveltogbackend.service.abstracts;

import koza.dev.traveltogbackend.dto.TravellerDto;
import koza.dev.traveltogbackend.dto.requests.CreateTravellerRequest;
import koza.dev.traveltogbackend.dto.requests.UpdateTravellerRequest;
import koza.dev.traveltogbackend.model.Traveller;

import java.util.List;

public interface TravellerService {

    TravellerDto createTraveller(CreateTravellerRequest request);

    public List<TravellerDto> getAll();

    TravellerDto getTravellerByUUID(String UUID);

    Traveller findTravellerByUUID(String UUID);

    TravellerDto updateTraveller(String UUID, UpdateTravellerRequest request);

    void deleteTraveller(String UUID);
}
