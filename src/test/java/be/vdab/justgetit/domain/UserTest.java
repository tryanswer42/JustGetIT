package be.vdab.justgetit.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class UserTest {

    private User user;

    @BeforeEach
    void setUp() {
        user = new User(7,"ikke", "gij", "ww", true, false);
    }

    @Test
    void isManager() {
        assertThat(user.isManager()).isEqualTo(true);
    }

    @Test
    void isBediende() {
        assertThat(user.isBediende()).isEqualTo(false);
    }

    @Test
    void getId() {
        assertThat(user.getId()).isEqualTo(7);
    }

    @Test
    void getNaam() {
        assertThat(user.getNaam()).isEqualTo("ikke");
    }

    @Test
    void getLogin() {
        assertThat(user.getLogin()).isEqualTo("gij");
    }

    @Test
    void getWachtwoord() {
        assertThat(user.getWachtwoord()).isEqualTo("ww");
    }
}