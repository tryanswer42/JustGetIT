package be.vdab.justgetit.repositories;

import be.vdab.justgetit.domain.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {
    List<Categorie> findByIsSubcategorieEquals(boolean isSubctegorie);
    /*long create(Categorie categorie);
    void update(Categorie categorie);
    void delete(long id);
    Optional<Categorie> findById(long id);
    List<Categorie> findAll();*/
}
