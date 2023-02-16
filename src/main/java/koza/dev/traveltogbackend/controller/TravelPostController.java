package koza.dev.traveltogbackend.controller;

import koza.dev.traveltogbackend.dto.requests.CreateTravelPostRequest;
import koza.dev.traveltogbackend.models.TravelPost;
import koza.dev.traveltogbackend.service.TravelPostServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/post")
@RequiredArgsConstructor
public class TravelPostController {
    private final TravelPostServiceImpl travelPostService;

    @PostMapping("/create")
    public ResponseEntity<TravelPost> createPost(@RequestBody CreateTravelPostRequest request){
        return ResponseEntity.ok(travelPostService.createNewPost(request));
    }

}
