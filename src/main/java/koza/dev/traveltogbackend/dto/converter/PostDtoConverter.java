package koza.dev.traveltogbackend.dto.converter;

import koza.dev.traveltogbackend.dto.PostDto;
import koza.dev.traveltogbackend.dto.TravellerDto;
import koza.dev.traveltogbackend.model.Post;
import org.springframework.stereotype.Component;

@Component
public class PostDtoConverter {

    public PostDto convertTo(Post from){
        return PostDto.builder()
                .id(from.getId())
                .location(from.getLocation())
                .imageURLs(from.getImageURLs())
                .ratings(from.getRatings())
                .traveller_id(from.getTraveller().getId())
                .build();

    }
}
