package be.vdab.justgetit.repositories;

import be.vdab.justgetit.domain.Categorie;

import java.util.List;
import java.util.Optional;

public class JdbcCategorieRepositorie implements CategorieRepository {
    @Override
    public long create(Categorie categorie) {
        return 0;
    }

    @Override
    public void update(Categorie categorie) {

    }

    @Override
    public void delete(long id) {

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
