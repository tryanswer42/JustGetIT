package be.vdab.justgetit.forms;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

public class FormCategorieStap1 {
    @NotBlank
    private final String naam;
    private final BigDecimal winstmarge;
    private final boolean percentage;
    private final boolean subCategorie;
    private final long parentCategorieId;

    public FormCategorieStap1(String naam, BigDecimal winstmarge, boolean percentage, boolean subCategorie, long parentCategorieId) {
        this.naam = naam;
        this.winstmarge = winstmarge;
        this.percentage = percentage;
        this.subCategorie = subCategorie;
        this.parentCategorieId = parentCategorieId;
    }

    public String getNaam() {
        return naam;
    }

    public BigDecimal getWinstmarge() {
        return winstmarge;
    }

    public boolean isPercentage() {
        return percentage;
    }

    public boolean isSubCategorie() {
        return subCategorie;
    }

    public long getParentCategorieId() {
        return parentCategorieId;
    }
}
