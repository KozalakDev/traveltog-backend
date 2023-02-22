package koza.dev.traveltogbackend.controller;

import koza.dev.traveltogbackend.dto.TravellerDto;
import koza.dev.traveltogbackend.dto.requests.CreateTravellerRequest;
import koza.dev.traveltogbackend.model.Traveller;
import koza.dev.traveltogbackend.service.TravellerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/traveller")
@RequiredArgsConstructor
public class TravellerController {

    @Autowired
    private TravellerServiceImpl service;

    @PostMapping("/create")
    public ResponseEntity<TravellerDto> createTraveller(@RequestBody CreateTravellerRequest request){
        return ResponseEntity.ok(service.createTraveller(request));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<TravellerDto>> getAllTraveller(){
        return ResponseEntity.ok(service.getAll());
    }
}
