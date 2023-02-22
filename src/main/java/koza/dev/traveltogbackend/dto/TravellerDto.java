package koza.dev.traveltogbackend.dto;

import koza.dev.traveltogbackend.model.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TravellerDto {
    private int id;
    private String username;
    private String email;
    private String password;
    private String profileImage;

}
