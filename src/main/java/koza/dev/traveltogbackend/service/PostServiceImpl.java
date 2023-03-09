package koza.dev.traveltogbackend.service;

import koza.dev.traveltogbackend.dto.PostDto;
import koza.dev.traveltogbackend.dto.converter.PostDtoConverter;
import koza.dev.traveltogbackend.dto.requests.CreatePostRequest;
import koza.dev.traveltogbackend.exception.NotFoundException;
import koza.dev.traveltogbackend.model.Post;
import koza.dev.traveltogbackend.model.Traveller;
import koza.dev.traveltogbackend.repository.PostRepository;
import koza.dev.traveltogbackend.service.abstracts.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository repository;
    private final PostDtoConverter postDtoConverter;
    private final TravellerServiceImpl travellerService;
    @Override
    public PostDto createPost(CreatePostRequest request) {
        Traveller traveller = travellerService.findTravellerByUUID(request.getUuid());
        Post post = Post.builder()
                .location(request.getLocation())
                .ratings(request.getRatings())
                .imageURLs(request.getImageURLs())
                .traveller(traveller)
                .build();
        return postDtoConverter.convertTo(repository.save(post));
    }
    @Override
    public PostDto getPostById(int id){
        Post post = repository.findById(id);
        if(post == null){
            throw new NotFoundException("not such find a thing");
        }else{
            return postDtoConverter.convertTo(post);
        }
    }
    @Override
    public Post findPostById(int id){
        Post post = repository.findById(id);
        if(post == null){
            throw new NotFoundException("not such find a thing");
        }else{
            return post;
        }
    }

    @Override
    public List<PostDto> getPostAll(){
        return repository.findAll().stream()
                .map(postDtoConverter::convertTo)
                .collect(Collectors.toList());
    }

    @Override
    public PostDto updatePost(int Id, CreatePostRequest request){
        Post post = findPostById(Id);
        Post updatePost = Post.builder()
                .location(request.getLocation())
                .ratings(request.getRatings())
                .imageURLs(request.getImageURLs())
                .build();
        post.setLocation(updatePost.getLocation());
        post.setRatings(updatePost.getRatings());
        post.setImageURLs(updatePost.getImageURLs());
        return postDtoConverter.convertTo(repository.save(post));
    }



    @Override
    public void deletePost(int Id){
        Post post = repository.findById(Id);
        if(post == null){
            throw new NotFoundException("not such find a thing");
        }else{
            repository.delete(post);
        }
    }
}
