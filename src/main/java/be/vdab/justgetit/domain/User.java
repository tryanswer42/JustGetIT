package be.vdab.justgetit.domain;

public class User {
    private final long id;
    private final String naam;
    private final String login;
    private final String wachtwoord;
    private final boolean isManager;
    private final boolean isBediende;

    public User(long id, String naam, String login, String wachtwoord, boolean isManager, boolean isBediende) {
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
