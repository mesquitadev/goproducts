package com.mesquitadev.goproducts.service.impl;

import com.mesquitadev.goproducts.converter.IProductConverter;
import com.mesquitadev.goproducts.models.Product;
import com.mesquitadev.goproducts.repository.IProductRepository;
import com.mesquitadev.goproducts.service.IProductService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static com.mesquitadev.goproducts.utils.ExceptionMessage.PRODUTO_NAO_ENCONTRADO;

@AllArgsConstructor
@Service
public class ProductServiceImpl implements IProductService {

    private final IProductRepository productRepository;

    @Override
    public Page<Product> findAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, PRODUTO_NAO_ENCONTRADO));
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product update(Product product, Long id) {
        Product oldProduct  = findById(id);
        IProductConverter.productConverter.toEntity(product,
                oldProduct);
        return productRepository.save(oldProduct);
    }

    @Override
    public void deleteById(Long id) {
        Product product = findById(id);
        productRepository.delete(product);
    }
}
