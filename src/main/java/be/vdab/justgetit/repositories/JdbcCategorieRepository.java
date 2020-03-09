package be.vdab.justgetit.repositories;

import be.vdab.justgetit.domain.Categorie;
import be.vdab.justgetit.domain.WinstmarginTypeGewoon;
import be.vdab.justgetit.exceptions.CategorieNietGevondenException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class JdbcCategorieRepository implements CategorieRepository {

    private final JdbcTemplate template;
    private final SimpleJdbcInsert insert;
    private final RowMapper<Categorie> categorieRowMapper;

    public JdbcCategorieRepository(JdbcTemplate template) {
        this.template = template;
        this.insert = new SimpleJdbcInsert(this.template);
        insert.withTableName("categorieen");
        insert.usingGeneratedKeyColumns("id");
    }

    @Override
    public long create(Categorie categorie) {
        Map<String, Object> kolomWaarden = new HashMap<>();
        kolomWaarden.put("naam", categorie.getNaam());
        kolomWaarden.put("isSubcategorie", categorie.isSubcategorie());
        kolomWaarden.put("idVanSubcategorie", categorie.getIdVanSubcategorie());
        kolomWaarden.put("winstmargin", categorie.getWinstmargin());
        kolomWaarden.put("winstmarginTypeGewoon", categorie.getWinstmarginTypeGewoon());
        Number id = insert.executeAndReturnKey(kolomWaarden);
        return id.longValue();
    }

    @Override
    public void update(Categorie categorie) {
        String sql = "update categorieen set naam=?, isSubcategorie=?, idVanSubcategorie=?" +
                "winstmargin=?, winstmarginTypeGewoon=?";
        if (template.update(sql, categorie.getNaam(), categorie.isSubcategorie(), categorie.getIdVanSubcategorie(),
                categorie.getWinstmargin(), categorie.getWinstmarginTypeGewoon())==0){
            throw new CategorieNietGevondenException();
        }
    }

    @Override
    public void delete(long id) {
        template.update("delete from categorieen where id=?", id );
    }

    @Override
    public Optional<Categorie> findById(long id) {
        return Optional.empty();
    }

    @Override
    public List<Categorie> findAll() {
        return null;
    }
}
