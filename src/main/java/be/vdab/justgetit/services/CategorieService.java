package be.vdab.justgetit.services;

import be.vdab.justgetit.domain.Categorie;

import java.util.List;
import java.util.Optional;

public interface CategorieService {
    void create(Categorie categorie);
    void update(Categorie categorie);
    void delete(Categorie categorie);
    List<Categorie> findAll();
    Optional<Categorie> findById(long id);
}
