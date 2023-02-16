package koza.dev.traveltogbackend.dto.requests;

import lombok.Getter;

import java.util.List;
@Getter
public class CreateTravelPostRequest {
    private String description;
    private List<String> imageURLs;
    private List<Double> properties;
    private String location;

}
