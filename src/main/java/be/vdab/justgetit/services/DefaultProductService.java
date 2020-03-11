package be.vdab.justgetit.services;


import be.vdab.justgetit.domain.Product;
import be.vdab.justgetit.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DefaultProductService implements ProductService{

    private final ProductRepository productRepository;

    public DefaultProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public void update(Product product) {
        productRepository.update(product);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(long Id) {
        return productRepository.findById(Id);
    }

    @Override
    public List<Product> findByCategory(long CategoryId) {
        return null;
    }
}
