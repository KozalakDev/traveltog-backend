package koza.dev.traveltogbackend.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.xml.bind.Locatable;
import jdk.javadoc.doclet.Taglet;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.xml.stream.Location;
import java.time.LocalDate;
import java.util.*;

@Entity
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Table(name = "travel_post")
@Data
@ToString()

public class TravelPost extends BaseEntity{

    private String description;
    @Column(name="urls")
    @ElementCollection(targetClass=String.class)
    private List<String> imageURLs;
    @CreationTimestamp
    private LocalDate creationDate;
    @Column(name="ratings")
    @ElementCollection(targetClass=Double.class)
    private List<Double> ratings;


}
