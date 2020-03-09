package be.vdab.justgetit.domain;

import javax.persistence.Column;
import java.math.BigDecimal;

public class Categorie {

    private long id;
    private String naam;
    private long parentCategorie;
    private boolean isSubcategorie;
    @Column(name = "winstmargeType")
    private boolean winstmargeIsPercentage;
    private BigDecimal winstmarge;

    public Categorie(long id, String naam, long parentCategorie, boolean isSubcategorie,
                     boolean winstmargeIsPercentage, BigDecimal winstmarge) {
        this.id = id;
        this.naam = naam;
        this.parentCategorie = parentCategorie;
        this.isSubcategorie = isSubcategorie;
        this.winstmargeIsPercentage = winstmargeIsPercentage;
        this.winstmarge = winstmarge;
    }

    protected Categorie() {
    }

    public Categorie(long id, String naam, boolean isSubcategorie,
                     boolean winstmargeIsPercentage, BigDecimal winstmarge) {
        this.id = id;
        this.naam = naam;
        this.isSubcategorie = isSubcategorie;
        this.winstmargeIsPercentage = winstmargeIsPercentage;
        this.winstmarge = winstmarge;
    }

    public long getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }

    public long getParentCategorie() {
        return parentCategorie;
    }

    public boolean isSubcategorie() {
        return isSubcategorie;
    }

    public boolean isWinstmargeIsPercentage() {
        return winstmargeIsPercentage;
    }

    public BigDecimal getWinstmarge() {
        return winstmarge;
    }
}
