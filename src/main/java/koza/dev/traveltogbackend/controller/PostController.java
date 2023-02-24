package koza.dev.traveltogbackend.controller;

import koza.dev.traveltogbackend.dto.PostDto;
import koza.dev.traveltogbackend.dto.requests.CreatePostRequest;
import koza.dev.traveltogbackend.service.PostServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/post")
@RequiredArgsConstructor
public class PostController {

    private final PostServiceImpl service;

    @PostMapping("/create")
    public PostDto createPost(@RequestBody CreatePostRequest request){
        return service.createPost(request);
    }

    @GetMapping("/get/{Id}")
    public PostDto getPostById(@PathVariable int Id){return service.getPostById(Id);}

    @GetMapping("/getAll")
    public List<PostDto> getAllPost(){return service.getPostAll();}

    @PutMapping("/update/{Id}")
    public PostDto updatePost(@PathVariable int id, @RequestBody CreatePostRequest request){
        return service.updatePost(id,request);
    }

    @DeleteMapping("/delete/{Id}")
    public void deletePost(@PathVariable int id){
        service.deletePost(id);

    }

}
