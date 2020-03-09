package be.vdab.justgetit.repositories;

import be.vdab.justgetit.domain.Categorie;

import java.util.List;
import java.util.Optional;

public interface CategorieRepository {
    long create(Categorie categorie);
    void update(Categorie categorie);
    void delete(long id);
    Optional<Categorie> findById(long id);
    List<Categorie> findAll();
}
