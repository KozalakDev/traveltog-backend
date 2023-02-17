package koza.dev.traveltogbackend.dto.requests;

import lombok.Getter;

import java.util.HashMap;
import java.util.List;
@Getter
public class CreateTravelPostRequest {
    private String description;
    private List<String> imageURLs;
    private List<Double> ratings;


}

// lokasyon Turkey, Artvin, Şavşat
//