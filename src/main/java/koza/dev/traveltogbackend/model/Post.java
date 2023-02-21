package koza.dev.traveltogbackend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Table(name = "post")
public class Post extends BaseEntity {

    private String location;
    @Column(name="urls")
    @ElementCollection(targetClass=String.class)
    private List<String> imageURLs;
    @Column(name = "ratings")
    @ElementCollection(targetClass = Integer.class)
    private List<Integer> ratings;
    @CreationTimestamp
    private LocalDate CreationDate;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="traveller_id")
    private Traveller traveller;

}
