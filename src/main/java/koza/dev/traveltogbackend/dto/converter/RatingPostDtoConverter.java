package koza.dev.traveltogbackend.dto.converter;

import koza.dev.traveltogbackend.dto.PostDto;
import koza.dev.traveltogbackend.dto.RatingDto;
import koza.dev.traveltogbackend.dto.RatingPostDto;
import koza.dev.traveltogbackend.model.Post;
import org.springframework.stereotype.Component;

@Component
public class RatingPostDtoConverter {
    public RatingPostDto convertTo(Post from){
        return RatingPostDto.builder()
                .id(from.getId())
                .traveller(from.getTraveller())
                .imageURLs(from.getImageURLs())
                .build();

    }

}
