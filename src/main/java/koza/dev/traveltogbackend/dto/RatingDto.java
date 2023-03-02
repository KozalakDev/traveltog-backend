package koza.dev.traveltogbackend.dto;

import koza.dev.traveltogbackend.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RatingDto extends BaseEntity {
    private int id;
    private String rating_name;
    private Double rating_value;
    private RatingPostDto post;
}
