package koza.dev.traveltogbackend.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Table(name = "post")
@ToString
@EqualsAndHashCode
public class Post extends BaseEntity {
    @Column(name = "location")
    @ElementCollection(targetClass = String.class)
    private Map<String,String> location;
    @Column(name="urls")
    @ElementCollection(targetClass=String.class)
    private List<String> imageURLs;
    @Column(name = "ratings")
    @ElementCollection(targetClass = Double.class)
    private Map<String,Double> ratings;
    @CreationTimestamp
    private LocalDateTime CreationDate;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="traveller_id")
    private Traveller traveller;


}
