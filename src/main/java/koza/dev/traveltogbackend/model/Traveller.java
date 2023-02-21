package koza.dev.traveltogbackend.model;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Table(name = "traveller")
@ToString
public class Traveller extends BaseEntity{
    private String username;
    private String email;
    private String password;
    private String profileImage;
}
