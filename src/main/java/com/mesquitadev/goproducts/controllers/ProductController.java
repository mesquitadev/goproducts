package com.mesquitadev.goproducts.controllers;

import com.mesquitadev.goproducts.converter.IProductConverter;
import com.mesquitadev.goproducts.dto.requests.ProductPersist;
import com.mesquitadev.goproducts.dto.requests.ProductUpdate;
import com.mesquitadev.goproducts.dto.responses.ProductResponse;
import com.mesquitadev.goproducts.models.Product;
import com.mesquitadev.goproducts.service.IProductService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.mesquitadev.goproducts.utils.Constants.*;

@RestController
@RequestMapping(ROOT + VERSION + PRODUCT_PATH)
@AllArgsConstructor
public class ProductController {

    private final IProductService productService;

    @GetMapping()
    public ResponseEntity<Page<ProductResponse>> findAll(Pageable pageable) {
        Page<Product> products = productService.findAllProducts(pageable);
        return ResponseEntity.ok(IProductConverter.productConverter.pageEntityToResponse(products));
    }

    @GetMapping(ID)
    public ResponseEntity<ProductResponse> findById(@PathVariable Long id) {
        Product product = productService.findById(id);
        return ResponseEntity.ok(IProductConverter.productConverter.entityToResponse(product));
    }

    @PostMapping()
    public ResponseEntity<ProductResponse> save(@RequestBody @Valid ProductPersist productPersist) {
        Product product = IProductConverter.productConverter.persistToEntity(productPersist);
        product = productService.save(product);

        return ResponseEntity.ok(IProductConverter.productConverter.entityToResponse(product));
    }

    @PatchMapping(ID)
    public ResponseEntity<ProductResponse> update(@RequestBody @Valid ProductUpdate productUpdate, @PathVariable Long id) {
        Product product = IProductConverter.productConverter.updateToEntity(productUpdate);
        product = productService.update(product, id);
        return ResponseEntity.ok(IProductConverter.productConverter.entityToResponse(product));
    }



    @DeleteMapping(ID)
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        productService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
