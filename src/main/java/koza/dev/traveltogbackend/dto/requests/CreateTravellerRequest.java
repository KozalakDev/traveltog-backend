package koza.dev.traveltogbackend.dto.requests;

import lombok.Getter;

@Getter
public class CreateTravellerRequest {
    private String uuid;
    private String username;
    private String email;
    private String password;
    private String profileImage;


}
