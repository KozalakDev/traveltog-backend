package koza.dev.traveltogbackend.dto.converter;

import koza.dev.traveltogbackend.dto.TravellerDto;
import koza.dev.traveltogbackend.model.Traveller;

public class TravellerDtoConverter {

    public TravellerDto convertTo(Traveller from){
        return TravellerDto.builder()
                .id(from.getId())
                .email(from.getEmail())
                .password(from.getPassword())
                .profileImage(from.getProfileImage())
                .build();
    }

}
