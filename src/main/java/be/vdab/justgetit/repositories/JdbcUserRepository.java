package be.vdab.justgetit.repositories;

import be.vdab.justgetit.domain.User;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.Optional;

public class JdbcUserRepository implements UserRepository {


    private final JdbcTemplate template;


    public JdbcUserRepository(JdbcTemplate template) {
        this.template = template;
    }


    private final RowMapper<User> userMapper = (result, rowNum) -> new User(
            result.getLong("id"),
            result.getString("naam"),
            result.getString("login"),
            result.getString("wachtwoord"),
            result.getBoolean("isManager"),
            result.getBoolean("isBediende"));

    @Override
    public Optional<User> findById(long id) {
        try {
            String sql = "select id, naam, login, wachtwoord, isManager, isBediende from users where id=?";
            return Optional.of(template.queryForObject(sql, userMapper, id));
        } catch (IncorrectResultSizeDataAccessException ex) {
            return Optional.empty();
        }
    }
}

