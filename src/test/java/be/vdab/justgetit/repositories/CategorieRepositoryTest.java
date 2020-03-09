package be.vdab.justgetit.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

@JdbcTest
@Import(CategorieRepository.class)
@Sql("insertCategorie.sql")
public class CategorieRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {
    private final CategorieRepository repository;

    public CategorieRepositoryTest(CategorieRepository repository) {
        this.repository = repository;
    }

//    private long idVanTestCategorie() {
//        return super.jdbcTemplate.queryForObject("");
//    }


//    @Test
//    void create() {
//        long id = idVanTestCategorie();
//    }
}
