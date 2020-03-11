package be.vdab.justgetit.repositories;

import be.vdab.justgetit.domain.Categorie;
import be.vdab.justgetit.exceptions.CategorieNietGevondenException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

//@Repository
public class JdbcCategorieRepository /*implements CategorieRepository*/ {

   /* private final JdbcTemplate template;
    private final SimpleJdbcInsert insert;
    private final RowMapper<Categorie> categorieRowMapper =
            ((result, rowNum) ->
                    new Categorie(result.getLong("id"), result.getString("naam"),
                            result.getLong("parentCategorie"), result.getBoolean("isSubcategorie"),
                            result.getBoolean("winstmargeIsPercentage"), result.getBigDecimal("winstmarge")));

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
        kolomWaarden.put("parentCategorie", categorie.getParentId());
        kolomWaarden.put("isSubcategorie", categorie.isSubcategorie());
        kolomWaarden.put("winstmargeIsPercentage", categorie.isWinstmargeIsPercentage());
        kolomWaarden.put("winstmarge", categorie.getWinstmarge());
        Number id = insert.executeAndReturnKey(kolomWaarden);
        return id.longValue();
    }

    @Override
    public void update(Categorie categorie) {
        String sql = "update categorieen set naam=?, parentId=?, isSubcategorie=?," +
                "winstmargeIsPercentage=?, winstmarge=? where id=?";
        if (template.update(sql, categorie.getNaam(), categorie.getParentId(), categorie.isSubcategorie(),
                categorie.isWinstmargeIsPercentage(), categorie.getWinstmarge(),  categorie.getId())==0){
            throw new CategorieNietGevondenException();
        }
    }

    @Override
    public void delete(long id) {
        template.update("delete from categorieen where id=?", id );
    }

    @Override
    public Optional<Categorie> findById(long id) {
        try {
            String sql = "select id, naam, parentId, isSubcategorie, winstmargeIsPercentage, winstmarge from categorieen where id=?";
            return Optional.of(template.queryForObject(sql, categorieRowMapper, id));
        } catch (IncorrectResultSizeDataAccessException ex){
            return Optional.empty();
        }
    }

    @Override
    public List<Categorie> findAll() {
        String sql = "select id, naam, parentId, isSubcategorie, winstmargeIsPercentage, winstmarge from categorieen order by id";
        return template.query(sql, categorieRowMapper);
    }*/
}
