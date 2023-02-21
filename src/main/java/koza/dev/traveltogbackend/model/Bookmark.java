package koza.dev.traveltogbackend.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Bookmark extends BaseEntity{
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="traveller_id")
    private Traveller traveller;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="post_id")
    private Post post;
}
