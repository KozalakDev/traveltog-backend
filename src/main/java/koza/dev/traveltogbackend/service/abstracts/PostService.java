package koza.dev.traveltogbackend.service.abstracts;

import koza.dev.traveltogbackend.dto.PostDto;
import koza.dev.traveltogbackend.dto.requests.CreatePostRequest;

import java.util.List;

public interface PostService {
    public PostDto createPost(CreatePostRequest request);

    PostDto getPostById(int id);

    List<PostDto> getPostAll();

    PostDto updatePost(int id, CreatePostRequest request);

    void deletePost(int Id);
}
