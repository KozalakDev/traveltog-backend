package koza.dev.traveltogbackend.repository;

import koza.dev.traveltogbackend.models.TravelPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TravelPostRepository extends JpaRepository<TravelPost, Long> {
}
