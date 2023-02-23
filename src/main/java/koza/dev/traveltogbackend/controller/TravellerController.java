package koza.dev.traveltogbackend.controller;

import koza.dev.traveltogbackend.dto.TravellerDto;
import koza.dev.traveltogbackend.dto.requests.CreateTravellerRequest;
import koza.dev.traveltogbackend.exception.AlreadyExistsException;
import koza.dev.traveltogbackend.exception.ErrorResponse;
import koza.dev.traveltogbackend.service.TravellerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/traveller")
@RequiredArgsConstructor
public class TravellerController {

    private final TravellerServiceImpl service;

    @PostMapping("/create")
    public TravellerDto createTraveller(@RequestBody CreateTravellerRequest request) {
        return service.createTraveller(request);
    }
    @ExceptionHandler(value = AlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse handleTravellerAlreadyExistsException(AlreadyExistsException ex) {
        return new ErrorResponse(HttpStatus.CONFLICT.value(),
                ex.getMessage());
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<TravellerDto>> getAllTraveller() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<TravellerDto> getTraveller(@PathVariable int id){
        return ResponseEntity.ok(service.getTravellerById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TravellerDto> updateTraveller(@PathVariable int id, @RequestBody CreateTravellerRequest request){
        return ResponseEntity.ok(service.updateTraveller(id,request));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTraveller(@PathVariable int id){
        service.deleteTraveller(id);
    }


}


