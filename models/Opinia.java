package projekt.projekt.models;

import javax.persistence.*;


@Entity
@Table(name = "opinia", schema = "rolfrezpaw")
public class Opinia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;
    private String trescopinii;
    private Integer rating;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTrescopinii() {
        return trescopinii;
    }

    public void setTrescopinii(String trescopinii) {
        this.trescopinii = trescopinii;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}