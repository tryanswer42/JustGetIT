package be.vdab.justgetit.repositories;

import be.vdab.justgetit.domain.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class JdbcUserRepository implements UserRepository{


    private final JdbcTemplate template;



    public JdbcUserRepository(JdbcTemplate template) {
        this.template = template;
    }



    private final RowMapper<User> userMapper = (result, rowNum) -> new User(
            result.getLong("id"),
            result.getString("naam"),
            result.getString("login"),
            result.getString("wachtwoord"),
            result.getString("functie"));
}
