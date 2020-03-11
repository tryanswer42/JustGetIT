package be.vdab.justgetit.repositories;

import be.vdab.justgetit.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    void update(Product product);

    List<Product> findAll();

    Optional<Product> findById(long Id);

    List<Product> findByCategory(long CategoryId);
}
