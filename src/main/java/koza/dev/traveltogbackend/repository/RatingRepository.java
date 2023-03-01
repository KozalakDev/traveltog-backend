package koza.dev.traveltogbackend.repository;

import koza.dev.traveltogbackend.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Rating, Integer> {
}
