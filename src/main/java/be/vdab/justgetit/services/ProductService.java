package be.vdab.justgetit.services;

import be.vdab.justgetit.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    void update(Product product);

    List<Product> findAll();

    Optional<Product> findById(long Id);

    List<Product> findByCategory(long CategoryId);
}
