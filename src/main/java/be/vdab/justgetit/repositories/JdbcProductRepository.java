package be.vdab.justgetit.repositories;

import be.vdab.justgetit.domain.Product;
import be.vdab.justgetit.exceptions.ProductNietGevondenException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;
import java.util.Optional;

public class JdbcProductRepository implements ProductRepository {
    private  final JdbcTemplate template;

    private final RowMapper<Product> productMapper = (result, rowNum) -> new Product(
            result.getLong("id"),
            result.getString("naam"),
            result.getBigDecimal("aankoopprijs"),
            result.getBigDecimal("verkoopprijs"),
            result.getInt("categorie"),
            result.getInt("voorraad"),
            result.getInt("minimaleBestelhoeveelheid"));

    public JdbcProductRepository(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public void update(Product product) {
        String sql = "update producten set naam=?,aankoopprijs=?,verkoopprijs=?,categorie=?,voorraad=?,minimaleBestelhoeveelheid=? where id=?";
        if (template.update(sql,product.getNaam(), product.getAankoopprijs(), product.getVerkoopprijs(), product.getCategorie(),product.getVoorraad(),product.getMinimaleBestelhoeveelheid()) == 0) {
            throw new ProductNietGevondenException("Product niet gevonden");
        }
    }

    @Override
    public List<Product> findAll() {
        String sql = "select id, naam, aankoopprijs, verkoopprijs, categorie, voorraad, minimaleBestelhoeveelheid from producten order by naam";
        return template.query(sql, productMapper);
    }

    @Override
    public Optional<Product> findById(long id) {
        try {
            String sql = "select id, naam, aankoopprijs, verkoopprijs, categorie, voorraad, minimaleBestelhoeveelheid from producten where id=?";
            return Optional.of(template.queryForObject(sql, productMapper, id));
        } catch (IncorrectResultSizeDataAccessException ex) {
            return Optional.empty();
        }
    }

    @Override
    public List<Product> findByCategory(long categoryId) {
        String sql = "select id, naam, aankoopprijs, verkoopprijs, categorie, voorraad, minimaleBestelhoeveelheid from producten where categorie=? order by naam";
        return template.query(sql, productMapper, categoryId);
    }
}
