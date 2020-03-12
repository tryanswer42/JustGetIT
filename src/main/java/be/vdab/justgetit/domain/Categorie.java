package be.vdab.justgetit.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "categorieen")
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank
    private String naam;
//    private long parentId;
    private boolean isSubcategorie;
    @NotNull
    private boolean winstmargeIsPercentage;
    private BigDecimal winstmarge;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "parentId")
    private Categorie parentCategory;
    @OneToMany
    @JoinColumn(name = "parentId")
    private Set<Categorie> subCategories;
    @Version
    private long version;


    public boolean addSubCategorie(Categorie subCategorie) {
        boolean toegevoegd = subCategories.add(subCategorie);
        Categorie oudeParentCategorie = subCategorie.getParentCategory();
        if(oudeParentCategorie != null && oudeParentCategorie != this) {
            oudeParentCategorie.subCategories.remove(subCategorie);
        }
        if(oudeParentCategorie != this) {
            subCategorie.setParentCategory(this);
        }
        return toegevoegd;
    }
    public boolean removeSubCategorie(Categorie subCategorie) {
        boolean verwijd = subCategories.remove(subCategorie);
//        to be continued
        return verwijd;
    }

    public void setParentCategory(Categorie parentCategory) {
        if(!parentCategory.getSubCategories().contains(this)) {
            parentCategory.addSubCategorie(this);
        }
        this.parentCategory = parentCategory;
    }

//    public Categorie getParentId() {
//        return parentCategory;
//    }


    public Categorie getParentCategory() {
        return parentCategory;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Categorie)) return false;
        Categorie categorie = (Categorie) o;
        return Objects.equals(naam.toLowerCase(), categorie.naam.toLowerCase());
    }

    @Override
    public int hashCode() {
        return Objects.hash(naam.toLowerCase());
    }
}
