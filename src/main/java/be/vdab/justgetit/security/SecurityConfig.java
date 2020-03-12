package be.vdab.justgetit.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
class SecurityConfig extends WebSecurityConfigurerAdapter {
    private static final String USERS_BY_USERNAME = "select login as username, wachtwoord as paswoord, '1' as enabled " +
            "from users " +
            "where login=?";
    private static final String AUTHORITIES_BY_USERNAME = "select users.login as username, roles.naam as authorities " +
            "from users inner join userroles on users.id = userroles.userId " +
            "inner join roles on userroles.roleId = roles.id " +
            "where users.login = ?";
    private static final String MANAGER = "Manager";

    @Bean
    JdbcDaoImpl jdbcDao(DataSource dataSource) {
        JdbcDaoImpl impl = new JdbcDaoImpl();
        impl.setDataSource(dataSource);
        impl.setUsersByUsernameQuery(USERS_BY_USERNAME);
        impl.setAuthoritiesByUsernameQuery(AUTHORITIES_BY_USERNAME);
        return impl;
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .mvcMatchers("/images/**")
                .mvcMatchers("/css/**")
                .mvcMatchers("/js/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/categorieen")
                .and()
                .authorizeRequests()
//                .mvcMatchers("/**").permitAll()
                .mvcMatchers( "/login").permitAll()
                .mvcMatchers("/categorieen/toevoegen").hasAuthority(MANAGER)
                .mvcMatchers("/**").permitAll();
    }
}
