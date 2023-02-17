package koza.dev.traveltogbackend.service;

import koza.dev.traveltogbackend.dto.requests.CreateTravelPostRequest;
import koza.dev.traveltogbackend.models.TravelPost;
import koza.dev.traveltogbackend.repository.TravelPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TravelPostServiceImpl {

    private final TravelPostRepository postRepository;

    public TravelPost createNewPost(CreateTravelPostRequest request) {
        TravelPost post = TravelPost.builder()
                .imageURLs(request.getImageURLs())
                .description(request.getDescription())
                .ratings(request.getRatings())
                .build();
        postRepository.save(post);
        return post;
    }


}
