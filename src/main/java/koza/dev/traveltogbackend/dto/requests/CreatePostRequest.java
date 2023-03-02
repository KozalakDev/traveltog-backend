package koza.dev.traveltogbackend.dto.requests;

import koza.dev.traveltogbackend.model.Rating;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;


@Getter
public class CreatePostRequest {
    private int id;
    private List<String> imageURLs;
    private Map<String,Double> ratings;
    private int id;
}
