package koza.dev.traveltogbackend.service.abstracts;

import koza.dev.traveltogbackend.dto.TravellerDto;
import koza.dev.traveltogbackend.dto.requests.CreateTravellerRequest;

import java.util.List;

public interface TravellerService {

    TravellerDto createTraveller(CreateTravellerRequest request);

    public List<TravellerDto> getAll();

    TravellerDto getTravellerById(int Id);

    TravellerDto updateTraveller(int Id, CreateTravellerRequest request);
}
