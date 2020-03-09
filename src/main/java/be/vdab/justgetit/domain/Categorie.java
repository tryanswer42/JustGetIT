package be.vdab.justgetit.domain;

import javax.persistence.*;

@Entity
@Table(name = "categorieen")
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String naam;

    protected Categorie() {
    }

    public Categorie(String naam) {
        this.naam = naam;
    }

    public Categorie(long id, String naam) {
        this.id = id;
        this.naam = naam;
    }

    public long getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }
}
