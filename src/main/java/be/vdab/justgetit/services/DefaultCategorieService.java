package be.vdab.justgetit.services;

import be.vdab.justgetit.domain.Categorie;
import be.vdab.justgetit.repositories.CategorieRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
class DefaultCategorieService implements CategorieService {
    private final CategorieRepository categorieRepository;

    public DefaultCategorieService(CategorieRepository categorieRepository) {
        this.categorieRepository = categorieRepository;
    }

    @Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED)
    @Override
    public void create(Categorie categorie) {
        categorieRepository.save(categorie);
    }

    @Override
    @Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED)
    public void update(Categorie categorie) {
        categorieRepository.save(categorie);
    }

    @Override
    @Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED)
    public void delete(Categorie categorie) {
        categorieRepository.delete(categorie);
    }

    @Override
    public List<Categorie> findAll() {
        return categorieRepository.findAll();
    }

    @Override
    public Optional<Categorie> findById(long id) {
        return categorieRepository.findById(id);
    }

    @Override
    public List<Categorie> findAllSpecifiekCategorie(boolean isSubctegorie) {
        return categorieRepository.findByIsSubcategorieEquals(isSubctegorie);
    }
}
