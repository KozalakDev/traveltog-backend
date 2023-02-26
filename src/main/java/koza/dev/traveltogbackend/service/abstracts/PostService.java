package koza.dev.traveltogbackend.service.abstracts;

import koza.dev.traveltogbackend.dto.PostDto;
import koza.dev.traveltogbackend.dto.requests.CreatePostRequest;

import java.io.IOException;
import java.util.List;

public interface PostService {
    public PostDto createPost(CreatePostRequest request);

    PostDto getPostById(int id) throws IOException;

    List<PostDto> getPostAll();

    void deletePost(int Id);
}
