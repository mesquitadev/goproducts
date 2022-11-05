package br.com.positivoinvestimentos.controllers;

import br.com.positivoinvestimentos.converter.ICategoriaConverter;
import br.com.positivoinvestimentos.dto.requests.ProductPersist;
import br.com.positivoinvestimentos.dto.requests.ProductUpdate;
import br.com.positivoinvestimentos.dto.responses.CategoriaResponse;
import br.com.positivoinvestimentos.dto.responses.ProductResponse;
import br.com.positivoinvestimentos.models.Categoria;
import br.com.positivoinvestimentos.service.ICategoriaService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static br.com.positivoinvestimentos.utils.Constants.*;

@RestController
@RequestMapping(ROOT + VERSION + PRODUCT_PATH)
@AllArgsConstructor
public class CategoriaController {

    private final ICategoriaService categoriaService;

    @GetMapping()
    public ResponseEntity<Page<CategoriaResponse>> findAll(Pageable pageable) {
        Page<Categoria> categorias = categoriaService.findAll(pageable);
        return ResponseEntity.ok(ICategoriaConverter.categoriaConverter.pageEntityToResponse(categorias));
    }

    @GetMapping(ID)
    public ResponseEntity<CategoriaResponse> findById(@PathVariable Long id) {
        Categoria categoria = categoriaService.findById(id);
        return ResponseEntity.ok(ICategoriaConverter.categoriaConverter.entityToResponse(categoria));
    }

    @PostMapping()
    public ResponseEntity<CategoriaResponse> save(@RequestBody @Valid ProductPersist productPersist) {
        Categoria categoria = ICategoriaConverter.categoriaConverter.persistToEntity(productPersist);
        categoria = categoriaService.save(categoria);

        return ResponseEntity.ok(ICategoriaConverter.categoriaConverter.entityToResponse(categoria));
    }

    @PatchMapping(ID)
    public ResponseEntity<CategoriaResponse> update(@RequestBody @Valid ProductUpdate productUpdate, @PathVariable Long id) {
        Categoria categoria = ICategoriaConverter.categoriaConverter.updateToEntity(productUpdate);
        categoria = categoriaService.update(categoria, id);
        return ResponseEntity.ok(ICategoriaConverter.categoriaConverter.entityToResponse(categoria));
    }



    @DeleteMapping(ID)
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        productService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
