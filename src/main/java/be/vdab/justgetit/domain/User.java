package be.vdab.justgetit.domain;

public class User {
    private final long id;
    private final String naam;
    private final String login;
    private final String wachtwoord;
    private final Functie functie;

    public User(long id, String naam, String login, String wachtwoord, Functie functie) {
        this.id = id;
        this.naam = naam;
        this.login = login;
        this.wachtwoord = wachtwoord;
        this.functie = functie;
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

    public Functie getFunctie() {
        return functie;
    }
}
