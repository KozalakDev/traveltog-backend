package koza.dev.traveltogbackend.repository;

import koza.dev.traveltogbackend.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
