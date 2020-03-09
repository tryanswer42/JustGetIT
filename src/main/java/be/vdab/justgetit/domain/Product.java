package be.vdab.justgetit.domain;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public class Product {
    @NotNull
    @PositiveOrZero
    private final long id;

    @NotBlank
    private final String naam;

    @PositiveOrZero
    @Digits(integer = 12, fraction = 2)
    private final BigDecimal aankoopprijs;

    @PositiveOrZero
    @Digits(integer = 12, fraction = 2)
    private final BigDecimal verkoopprijs;

    private final int categorie;
    private final int voorraad;
    private final int minimaleBestelhoeveelheid;

    public Product(@NotNull @PositiveOrZero long id, @NotBlank String naam, @PositiveOrZero @Digits(integer = 12, fraction = 2) BigDecimal aankoopprijs, @PositiveOrZero @Digits(integer = 12, fraction = 2) BigDecimal verkoopprijs, int categorie, int voorraad, int minimaleBestelhoeveelheid) {
        this.id = id;
        this.naam = naam;
        this.aankoopprijs = aankoopprijs;
        this.verkoopprijs = verkoopprijs;
        this.categorie = categorie;
        this.voorraad = voorraad;
        this.minimaleBestelhoeveelheid = minimaleBestelhoeveelheid;
    }

    public long getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }

    public BigDecimal getAankoopprijs() {
        return aankoopprijs;
    }

    public BigDecimal getVerkoopprijs() {
        return verkoopprijs;
    }

    public int getCategorie() {
        return categorie;
    }

    public int getVoorraad() {
        return voorraad;
    }

    public int getMinimaleBestelhoeveelheid() {
        return minimaleBestelhoeveelheid;
    }
}
