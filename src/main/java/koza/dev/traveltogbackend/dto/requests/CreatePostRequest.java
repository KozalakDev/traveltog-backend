package koza.dev.traveltogbackend.dto.requests;

import lombok.Getter;
import java.util.List;
import java.util.Map;

@Getter
public class CreatePostRequest {
    private int id;
    private String UUID;
    private Map<String,String> location;
    private List<String> imageURLs;
    private Map<String,Double> ratings;
}
