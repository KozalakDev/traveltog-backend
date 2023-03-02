package koza.dev.traveltogbackend.service.abstracts;

import koza.dev.traveltogbackend.dto.PostDto;
import koza.dev.traveltogbackend.dto.requests.CreatePostRequest;
import koza.dev.traveltogbackend.model.Post;

import java.io.IOException;
import java.util.List;

public interface PostService {
     PostDto createPost(CreatePostRequest request);

    Post findPostById(int id) ;

    PostDto getPostById(int id);

    List<PostDto> getPostAll();

    void deletePost(int Id);
}
