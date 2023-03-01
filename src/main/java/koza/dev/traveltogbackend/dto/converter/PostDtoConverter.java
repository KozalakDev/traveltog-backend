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
                .ratings_id(from.getRatings() == null ? null :
                        from.getRatings().stream().map(rating -> rating.getId())
                        .collect(Collectors.toList()))
                .traveller_id(from.getTraveller().getId())
                .build();

    }
}
