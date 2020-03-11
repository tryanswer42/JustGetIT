package be.vdab.justgetit.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

public class User {
    @NotBlank
    @PositiveOrZero
    private final long id;
    @NotBlank
    private final String naam;
    @NotBlank
    private final String login;
    @NotBlank
    @Size(min=8)
    private final String wachtwoord;
    @NotNull
    private final boolean isManager;
    @NotNull
    private final boolean isBediende;

    public User(@NotBlank @PositiveOrZero long id, @NotBlank String naam, @NotBlank String login, @NotBlank String wachtwoord, @NotNull boolean isManager, @NotNull boolean isBediende) {
        this.id = id;
        this.naam = naam;
        this.login = login;
        this.wachtwoord = wachtwoord;
        this.isManager = isManager;
        this.isBediende = isBediende;
    }

    public boolean isManager() {
        return isManager;
    }

    public boolean isBediende() {
        return isBediende;
    }

    public long getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }

    public String getLogin() {
        return login;
    }

    public String getWachtwoord() {
        return wachtwoord;
    }

}
