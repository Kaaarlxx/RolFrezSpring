package projekt.projekt.models;

import javax.persistence.*;



@Entity
@Table(name = "zgloszenie", schema = "rolfrezpaw")
public class Zgloszenie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String opis;
    private Double cena;
    private String status;
    private String komentarzadmina;

    @ManyToOne
    private User user;

    @ManyToOne
    private Typy_zgloszen typ;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Double getCena() {
        return cena;
    }

    public void setCena(Double cena) {
        this.cena = cena;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getKomentarzadmina() {
        return komentarzadmina;
    }

    public void setKomentarzadmina(String komentarzadmina) {
        this.komentarzadmina = komentarzadmina;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Typy_zgloszen getTyp() {
        return typ;
    }

    public void setTyp(Typy_zgloszen typ) {
        this.typ = typ;
    }
}