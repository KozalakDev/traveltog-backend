package koza.dev.traveltogbackend.dto.converter;

import koza.dev.traveltogbackend.dto.PostDto;
import koza.dev.traveltogbackend.model.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PostDtoConverter {
    private final PostRatingDtoConverter postRatingDtoConverter;

    public PostDto convertTo(Post from){
        return PostDto.builder()
                .id(from.getId())
                .imageURLs(from.getImageURLs())
                .ratings(from.getRatings())
                .traveller_id(from.getTraveller().getId())
                .build();

    }
}
