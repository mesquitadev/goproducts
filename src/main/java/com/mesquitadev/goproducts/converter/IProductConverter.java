package com.mesquitadev.goproducts.converter;

import com.mesquitadev.goproducts.dto.requests.ProductPersist;
import com.mesquitadev.goproducts.dto.requests.ProductUpdate;
import com.mesquitadev.goproducts.dto.responses.ProductResponse;
import com.mesquitadev.goproducts.models.Product;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring")
public interface IProductConverter {
    IProductConverter productConverter = Mappers.getMapper(IProductConverter.class);

    ProductResponse entityToResponse(Product product);

    default Page<ProductResponse> pageEntityToResponse(Page<Product> products) {
        return products.map(this::entityToResponse);
    }

    Product persistToEntity(ProductPersist productPersist);

    Product updateToEntity(ProductUpdate productUpdate);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void toEntity(Product product, @MappingTarget Product newProduct);
}
