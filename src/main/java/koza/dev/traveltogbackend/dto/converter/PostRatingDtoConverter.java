package koza.dev.traveltogbackend.dto.converter;

import koza.dev.traveltogbackend.dto.PostRatingDto;
import koza.dev.traveltogbackend.model.Rating;
import org.springframework.stereotype.Component;

@Component
public class PostRatingDtoConverter {
    public PostRatingDto convertTo(Rating from){
        return PostRatingDto.builder()
                .rating_name(from.getRating_name())
                .rating_value(from.getRating_value())
                .build();
    }
}
