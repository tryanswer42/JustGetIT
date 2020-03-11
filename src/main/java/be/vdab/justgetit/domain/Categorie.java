package be.vdab.justgetit.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.Set;

@Entity
@Table(name = "categorieen")
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String naam;
//    private long parentId;
    private boolean isSubcategorie;
    private boolean winstmargeIsPercentage;
    private BigDecimal winstmarge;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "parentId")
    private Categorie parentCategory;
    @OneToMany
    @JoinColumn(name = "parentId")
    private Set<Categorie> subCategories;


    public void addSubCategorie(Categorie categorie) {

    }
    public void removeSubCategorie(Categorie categorie) {

    }

    public void setParentCategory(Categorie parentCategory) {
        this.parentCategory = parentCategory;
    }

//    public Categorie getParentId() {
//        return parentCategory;
//    }

    public Set<Categorie> getSubCategories() {
        return Collections.unmodifiableSet(subCategories);
    }

    protected Categorie() {
    }

//    public Categorie(long id, String naam, long parentId, boolean isSubcategorie,
//                     boolean winstmargeIsPercentage, BigDecimal winstmarge) {
//        this.id = id;
//        this.naam = naam;
//        this.parentId = parentId;
//        this.isSubcategorie = isSubcategorie;
//        this.winstmargeIsPercentage = winstmargeIsPercentage;
//        this.winstmarge = winstmarge;
//    }


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

//    public long getparentId() {
//        return parentId;
//    }

    public boolean getIsSubcategorie() {
        return isSubcategorie;
    }

    public boolean isWinstmargeIsPercentage() {
        return winstmargeIsPercentage;
    }

    public BigDecimal getWinstmarge() {
        return winstmarge;
    }
}
