package koza.dev.traveltogbackend.dto.requests;

import koza.dev.traveltogbackend.enums.RatingType;
import lombok.Getter;

@Getter
public class CreateRatingRequest {
    private RatingType rating_name;
    private Double rating_value;
}
