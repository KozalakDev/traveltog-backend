package koza.dev.traveltogbackend.controller;

import koza.dev.traveltogbackend.dto.PostRatingDto;
import koza.dev.traveltogbackend.dto.RatingDto;
import koza.dev.traveltogbackend.dto.requests.CreateRatingRequest;
import koza.dev.traveltogbackend.model.Post;
import koza.dev.traveltogbackend.model.Rating;
import koza.dev.traveltogbackend.repository.RatingRepository;
import koza.dev.traveltogbackend.service.RatingServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/post/rating")
@RequiredArgsConstructor
public class RatingController {
    private final RatingServiceImpl service;

    @PostMapping("/{post_id}/create")
    public PostRatingDto createRating(@PathVariable int post_id, @RequestBody CreateRatingRequest request){
        return service.createRating(post_id,request);
    }


}
