package br.com.positivoinvestimentos.service;

import br.com.positivoinvestimentos.models.Categoria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICategoriaService {
    Page<Categoria> findAll(Pageable pageable);

    Categoria findById(Long id);

    Categoria save(Categoria categoria);
    Categoria update(Categoria categoria, Long id);

    void deleteById(Long id);
}
