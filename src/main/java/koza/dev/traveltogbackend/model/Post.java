package koza.dev.traveltogbackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Table(name = "post")
@ToString
@EqualsAndHashCode
public class Post extends BaseEntity {
    @Column(name="urls")
    @ElementCollection(targetClass=String.class)
    private List<String> imageURLs;
    @OneToMany(targetEntity = Rating.class, cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "pr_id",referencedColumnName = "id")
    @JsonManagedReference
    private List<Rating> ratings ;
    @CreationTimestamp
    private LocalDateTime CreationDate;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="traveller_id")
    @JsonBackReference
    private Traveller traveller;

}
