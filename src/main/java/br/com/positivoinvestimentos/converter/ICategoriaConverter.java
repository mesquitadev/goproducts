package br.com.positivoinvestimentos.converter;

import br.com.positivoinvestimentos.dto.requests.ProductPersist;
import br.com.positivoinvestimentos.dto.requests.ProductUpdate;
import br.com.positivoinvestimentos.dto.responses.CategoriaResponse;
import br.com.positivoinvestimentos.models.Categoria;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring")
public interface ICategoriaConverter {
    ICategoriaConverter categoriaConverter = Mappers.getMapper(ICategoriaConverter.class);

    CategoriaResponse entityToResponse(Categoria categoria);

    default Page<CategoriaResponse> pageEntityToResponse(Page<Categoria> categorias) {
        return categorias.map(this::entityToResponse);
    }

    Product persistToEntity(ProductPersist productPersist);

    Product updateToEntity(ProductUpdate productUpdate);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void toEntity(Categoria categoria, @MappingTarget Categoria newCategoria);
}
