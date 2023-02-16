package koza.dev.traveltogbackend.models;

import com.sun.xml.bind.Locatable;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.xml.stream.Location;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Table(name = "travel_post")
@Data
@ToString()

public class TravelPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    private String description;
    @Column(name="urls")
    @ElementCollection(targetClass=String.class)
    private List<String> imageURLs;
    @CreationTimestamp
    private Date creationDate;
    @Column(name="properties")
    @ElementCollection(targetClass=Double.class)
    private List<Double> properties;
    private String location;






}
