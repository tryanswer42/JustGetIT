package be.vdab.justgetit.repositories;

import be.vdab.justgetit.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import javax.sql.DataSource;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@JdbcTest
@Sql("/insertTestUser.sql")
@Import(JdbcUserRepository.class)
class UserRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {

    private JdbcUserRepository repo;

    public UserRepositoryTest(JdbcUserRepository repository) {
        this.repo = repository;
    }

    long getInsertedTestId() {
        return super.jdbcTemplate.queryForObject(
                "select id from users where naam = 'ikke'", Long.class);
    }

    @Test
    void findByNonExistingId() {
        Optional<User> gelezenUser = repo.findById(-1);   // -1 wordt niet toegekend door autonumber field
        assertThat(gelezenUser.isPresent()).isEqualTo(false);
    }

    @Test
    void findByExistingId() {
        long id = getInsertedTestId();
        Optional<User> gelezenUser = repo.findById(id);
        assertThat(gelezenUser.isPresent()).isEqualTo(true);
        User user = gelezenUser.get();
        assertThat(user.getNaam()).isEqualTo("ikke");
        assertThat(user.getWachtwoord()).isEqualTo("ww");
        assertThat(user.getLogin()).isEqualTo("gij");
        assertThat(user.getId()).isEqualTo(id);
    }

}