package koza.dev.traveltogbackend.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import koza.dev.traveltogbackend.dto.PostRatingDto;
import koza.dev.traveltogbackend.dto.RatingDto;
import koza.dev.traveltogbackend.dto.converter.PostRatingDtoConverter;
import koza.dev.traveltogbackend.dto.converter.RatingDtoConverter;
import koza.dev.traveltogbackend.dto.requests.CreateRatingRequest;
import koza.dev.traveltogbackend.model.Post;
import koza.dev.traveltogbackend.model.Rating;
import koza.dev.traveltogbackend.repository.RatingRepository;
import koza.dev.traveltogbackend.service.abstracts.RatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RatingServiceImpl implements RatingService {

    private final RatingRepository repository;
    private final PostServiceImpl service;
    private final PostRatingDtoConverter postRatingDtoConverter;
    public PostRatingDto createRating(int id,CreateRatingRequest request){
        ObjectMapper objectMapper = new ObjectMapper();


        Post post = service.findPostById(id);
        Rating rating = Rating.builder()
                .rating_name(request.getRating_name())
                .rating_value(request.getRating_value())
                .post(post)
                .build();

        return postRatingDtoConverter.convertTo(repository.save(rating));
    }


}
