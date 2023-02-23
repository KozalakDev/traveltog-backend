package koza.dev.traveltogbackend.repository;

import koza.dev.traveltogbackend.dto.TravellerDto;
import koza.dev.traveltogbackend.model.Traveller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TravellerRepository extends JpaRepository<Traveller, Integer> {
    Traveller findById(int Id);
    Boolean existsTravellerByEmailAndUsername(String email,String username);
    Traveller findTravellerByUsernameAndEmail(String username, String email);
}
