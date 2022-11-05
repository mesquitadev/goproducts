package br.com.positivoinvestimentos.service.impl;

import br.com.positivoinvestimentos.converter.ICategoriaConverter;
import br.com.positivoinvestimentos.models.Categoria;
import br.com.positivoinvestimentos.repository.ICategoriaRepository;
import br.com.positivoinvestimentos.service.ICategoriaService;
import br.com.positivoinvestimentos.utils.ExceptionMessage;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@AllArgsConstructor
@Service
public class CategoriaServiceImpl implements ICategoriaService {

    private final ICategoriaRepository categoriaRepository;

    @Override
    public Page<Categoria> findAll(Pageable pageable) {
        return categoriaRepository.findAll(pageable);
    }

    @Override
    public Categoria findById(Long id) {
        return categoriaRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, ExceptionMessage.PRODUTO_NAO_ENCONTRADO));
    }

    @Override
    public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public Categoria update(Categoria categoria, Long id) {
        Categoria oldCategoria = findById(id);
        ICategoriaConverter.categoriaConverter.toEntity(categoria,
                oldCategoria);
        return categoriaRepository.save(oldCategoria);
    }

    @Override
    public void deleteById(Long id) {
        Categoria categoria = findById(id);
        categoriaRepository.delete(categoria);
    }
}
