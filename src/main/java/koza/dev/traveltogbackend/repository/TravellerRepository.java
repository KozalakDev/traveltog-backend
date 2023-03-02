package koza.dev.traveltogbackend.repository;

import koza.dev.traveltogbackend.dto.TravellerDto;
import koza.dev.traveltogbackend.model.Traveller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TravellerRepository extends JpaRepository<Traveller, Integer> {
    Traveller findById(int Id);
    @Query("SELECT t FROM Traveller t WHERE t.UUID LIKE %?1%")
    Traveller findTravellerByUUID(String UUID);
    Boolean existsTravellerByEmailAndUsername(String email,String username);
    Traveller findTravellerByUsernameAndEmail(String username, String email);
}
