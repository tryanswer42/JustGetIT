package be.vdab.justgetit.repositories;

import be.vdab.justgetit.domain.Categorie;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import be.vdab.justgetit.exceptions.CategorieNietGevondenException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import java.math.BigDecimal;

@DataJpaTest
@Import(JdbcCategorieRepository.class)
@Sql("/insertCategorie.sql")
public class JdbcCategorieRepositorieTest
        extends AbstractTransactionalJUnit4SpringContextTests {
    private final JdbcCategorieRepository repository;
    private final String CATEGORIEEN = "categorieen";

    public JdbcCategorieRepositorieTest(JdbcCategorieRepository repository) {
        this.repository = repository;
    }

   /* @Test
    void create() {
        long id = repository.create(new Categorie(0, "test",
                true, true, BigDecimal.TEN));
        assertThat(id).isPositive();
        assertThat(super.countRowsInTableWhere(CATEGORIEEN, "id= "+id)).isOne();
    }

    private long idVanTestCategorie() {
        return super.jdbcTemplate.queryForObject("select id from categorieen " +
                "where naam = 'testParent'", Long.class);
    }

    @Test
    void findById() {
        assertThat(repository.findById(idVanTestCategorie()).get().getNaam()).isEqualTo("testParent");
    }

    @Test
    void findByOnbestaandeIdVindtGeenCategorie() {
        assertThat(repository.findById(-1)).isEmpty();
    }

    @Test
    void delete() {
        long id = idVanTestCategorie();
        repository.delete(id);
        assertThat(super.countRowsInTableWhere(CATEGORIEEN, "id= "+id)).isZero();
    }

    @Test
    void update() {
        long id = idVanTestCategorie();
        Categorie categorie = new Categorie(id, "testNieuwe",0,
                true, false, BigDecimal.ONE);
        repository.update(categorie);
        assertThat(super.jdbcTemplate.queryForObject("select winstmarge from categorieen where id = ?", BigDecimal.class, id))
                .isOne();
    }

    @Test
    void updateOnbestaandeCategorieGeeftEenFout() {
        assertThatExceptionOfType(CategorieNietGevondenException.class).isThrownBy(() -> {
            repository.update(new Categorie(-1, "test",
                    true, true, BigDecimal.TEN));
        });
    }*/
}
