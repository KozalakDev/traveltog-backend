package koza.dev.traveltogbackend.repository;

import koza.dev.traveltogbackend.model.Traveller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TravellerRepository extends JpaRepository<Traveller, Integer> {
}
