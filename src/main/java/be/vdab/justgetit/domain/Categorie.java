package be.vdab.justgetit.domain;

import java.math.BigDecimal;

public class Categorie {

    private final long id;
    private final String naam;
    private final long parentCategorie;
    private final boolean isSubcategorie;
    private final boolean winstmargeIsPercentage;
    private final BigDecimal winstmarge;

    public Categorie(long id, String naam, long parentCategorie, boolean isSubcategorie,
                     boolean winstmargeIsPercentage, BigDecimal winstmarge) {
        this.id = id;
        this.naam = naam;
        this.parentCategorie = parentCategorie;
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
