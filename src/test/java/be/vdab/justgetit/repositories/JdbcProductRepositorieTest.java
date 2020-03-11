package be.vdab.justgetit.repositories;

import be.vdab.justgetit.domain.Product;
import be.vdab.justgetit.exceptions.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@JdbcTest
@Import(JdbcProductRepository.class)
@Sql("/insertCategorieandProduct.sql")
public class JdbcProductRepositorieTest

        extends AbstractTransactionalJUnit4SpringContextTests {

    private final JdbcProductRepository repository;

    private final String PRODUCTEN = "producten";

    public JdbcProductRepositorieTest(JdbcProductRepository repository) {
        this.repository = repository;
    }

    private long idVanTestProduct() {
        return super.jdbcTemplate.queryForObject("select id from producten " +
                "where naam = 'testProduct'", Long.class);
    }


    @Test
    void update() {
        long id = idVanTestProduct();
        Product product = new Product(id, "testNieuwe", BigDecimal.TEN, BigDecimal.TEN, 4, 1, 1);
        repository.update(product);
        assertThat(super.jdbcTemplate.queryForObject("select naam from producten where id = ?", String.class, id))
                .isEqualTo("testNieuwe");
    }

    @Test
    void updateOnbestaandeCategorieGeeftEenFout() {
        assertThatExceptionOfType(ProductNietGevondenException.class).isThrownBy(() -> {
            repository.update(new Product(-1, "test", BigDecimal.TEN, BigDecimal.TEN, 1, 1, 1));
        });
    }

    @Test
    void findById() {
        assertThat(repository.findById(idVanTestProduct()).get().getNaam()).isEqualTo("testProduct");
    }

    @Test
    void findByOnbestaandeIdVindtGeenProduct() {
        assertThat(repository.findById(-1)).isEmpty();
    }

    @Test
    void findAllProductGeeftalleBBrouwersGesorteerdOpNaam() {
        assertThat(repository.findAll())
                .hasSize(super.countRowsInTable(PRODUCTEN))
                .extracting(product -> product.getNaam().toLowerCase()).isSorted();
    }

    @Test
    void findByCategory() {
        assertThat(repository.findByCategory(5)).extracting(product -> product.getCategorie()).contains(5);
    }

    //----------------------------------------------------------


}
