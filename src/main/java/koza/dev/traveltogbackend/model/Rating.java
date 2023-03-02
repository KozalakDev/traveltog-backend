package koza.dev.traveltogbackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import koza.dev.traveltogbackend.enums.RatingType;
import lombok.*;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Table(name = "post_ratings")
@ToString
@EqualsAndHashCode
public class Rating extends BaseEntity{
    @JsonProperty("rating_name")
    private RatingType rating_name;
    @JsonProperty("rating_value")
    private Double rating_value;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pr_id",nullable = false)
    @JsonBackReference
    @JsonProperty
    private Post post;
}
