package koza.dev.traveltogbackend.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Table(name = "travel_post")
@Data
@ToString()
public class PostLocation extends BaseEntity {

    private String country;
    private String city;
    private String district;
}
