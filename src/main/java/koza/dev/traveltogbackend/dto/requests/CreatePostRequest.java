package koza.dev.traveltogbackend.dto.requests;

import koza.dev.traveltogbackend.model.Traveller;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
public class CreatePostRequest {
    private Map<String,String> location;
    private List<String> imageURLs;
    private Map<String,Double> ratings;
    private int id;
}
