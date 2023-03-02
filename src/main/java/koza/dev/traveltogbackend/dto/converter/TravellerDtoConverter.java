package koza.dev.traveltogbackend.dto.converter;

import koza.dev.traveltogbackend.dto.TravellerDto;
import koza.dev.traveltogbackend.model.Traveller;
import org.springframework.stereotype.Component;

@Component
public class TravellerDtoConverter {

    public TravellerDto convertTo(Traveller from){
        return TravellerDto.builder()
                .UUID(from.getUUID())
                .email(from.getEmail())
                .profileImage(from.getProfileImage())
                .username(from.getUsername())
                .password(from.getPassword())
                .build();
    }

}
