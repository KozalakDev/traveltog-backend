package koza.dev.traveltogbackend.service.abstracts;

import koza.dev.traveltogbackend.dto.PostDto;
import koza.dev.traveltogbackend.dto.requests.CreatePostRequest;
import koza.dev.traveltogbackend.model.Post;

import java.util.List;

public interface PostService {
    PostDto createPost(CreatePostRequest request);

    PostDto getPostById(int id);

    Post findPostById(int id);

    List<PostDto> getPostAll();

    PostDto updatePost(int id, CreatePostRequest request);

    void deletePost(int Id);
}
