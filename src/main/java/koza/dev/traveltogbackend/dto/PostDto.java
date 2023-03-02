package koza.dev.traveltogbackend.dto;

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
public class PostDto {
    int id;
    private List<String> imageURLs;
    private Map<String,Double> ratings;
    private int traveller_id;





}
