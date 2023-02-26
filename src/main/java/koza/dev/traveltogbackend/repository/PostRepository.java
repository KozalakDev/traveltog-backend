package koza.dev.traveltogbackend.repository;

import koza.dev.traveltogbackend.model.Post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
    Post findById(int Id);


}
