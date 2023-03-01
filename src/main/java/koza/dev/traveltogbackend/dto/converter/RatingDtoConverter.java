package koza.dev.traveltogbackend.dto.converter;

import koza.dev.traveltogbackend.dto.RatingDto;
import koza.dev.traveltogbackend.model.Rating;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RatingDtoConverter {
    private final RatingPostDtoConverter ratingPostDtoConverter;

    public RatingDto convertTo(Rating from){
        return RatingDto.builder()
                .id(from.getId())
                .rating_name(from.getRating_name().name())
                .rating_value(from.getRating_value())
                .post(ratingPostDtoConverter.convertTo(from.getPost()))
                .build();

    }
}
