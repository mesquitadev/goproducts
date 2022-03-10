package com.mesquitadev.goproducts.service;

import com.mesquitadev.goproducts.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    Page<Product> findAllProducts(Pageable pageable);

    Product findById(Long id);

    Product save(Product product);
    Product update(Product product, Long id);

    void deleteById(Long id);
}
