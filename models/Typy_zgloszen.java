package projekt.projekt.models;

import javax.persistence.*;



@Entity
@Table(name = "typy_zgloszen", schema = "rolfrezpaw")
public class Typy_zgloszen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String typ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }
}