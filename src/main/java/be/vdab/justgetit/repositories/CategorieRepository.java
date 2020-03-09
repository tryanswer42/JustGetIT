package be.vdab.justgetit.repositories;

import be.vdab.justgetit.domain.Categorie;
<<<<<<< HEAD
import org.springframework.data.jpa.repository.JpaRepository;
=======
>>>>>>> 2f07bfa6271eea3d7bb35931f166bf1a119951d8

import java.util.List;
import java.util.Optional;

public interface CategorieRepository {
<<<<<<< HEAD
=======

>>>>>>> 2f07bfa6271eea3d7bb35931f166bf1a119951d8
    long create(Categorie categorie);
    void update(Categorie categorie);
    void delete(long id);
    Optional<Categorie> findById(long id);
    List<Categorie> findAll();
<<<<<<< HEAD
=======


>>>>>>> 2f07bfa6271eea3d7bb35931f166bf1a119951d8
}
