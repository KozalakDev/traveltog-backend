package koza.dev.traveltogbackend.dto;

import koza.dev.traveltogbackend.enums.RatingType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostRatingDto {
    private RatingType rating_name;
    private Double rating_value;
}
