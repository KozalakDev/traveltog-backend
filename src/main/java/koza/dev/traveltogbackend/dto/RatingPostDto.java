package koza.dev.traveltogbackend.dto;

import koza.dev.traveltogbackend.model.Rating;
import koza.dev.traveltogbackend.model.Traveller;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RatingPostDto {
    private int id;
    private List<String> imageURLs;
    private Traveller traveller;
    private LocalDateTime creationDate;
}
