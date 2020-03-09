package be.vdab.justgetit.domain;

import java.math.BigDecimal;

public class Categorie {

    private final long id;
    private final String naam;
    private final boolean isSubcategorie;
    private final long idVanSubcategorie;
    private final BigDecimal winstmargin;
    private final WinstmarginTypeGewoon winstmarginTypeGewoon;

    public Categorie(long id, String naam, boolean isSubcategorie,
                     long idVanSubcategorie, BigDecimal winstmargin,
                     WinstmarginTypeGewoon winstmarginTypeGewoon) {
        this.id = id;
        this.naam = naam;
        this.isSubcategorie = isSubcategorie;
        this.idVanSubcategorie = idVanSubcategorie;
        this.winstmargin = winstmargin;
        this.winstmarginTypeGewoon = winstmarginTypeGewoon;
    }

    public long getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }

    public boolean isSubcategorie() {
        return isSubcategorie;
    }

    public long getIdVanSubcategorie() {
        return idVanSubcategorie;
    }

    public BigDecimal getWinstmargin() {
        return winstmargin;
    }

    public WinstmarginTypeGewoon getWinstmarginTypeGewoon() {
        return winstmarginTypeGewoon;
    }
}
