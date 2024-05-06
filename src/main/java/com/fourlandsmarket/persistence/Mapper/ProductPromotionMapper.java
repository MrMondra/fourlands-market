package com.fourlandsmarket.persistence.Mapper;

import com.fourlandsmarket.domain.dto.Product;
import com.fourlandsmarket.persistence.entity.ProductPromotionEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {ProductMapper.class, CategoryMapper.class, PromotionMapper.class})
public interface ProductPromotionMapper {

    @Mappings({
            @Mapping(source = "id.idProduct", target = "idProduct"),
            @Mapping(source = "productEntity.name", target = "name"),
            @Mapping(source = "productEntity.description", target = "description"),
            @Mapping(source = "productEntity.price", target = "price"),
            @Mapping(source = "productEntity.stock", target = "stock"),
            @Mapping(source = "productEntity.categoryEntity", target = "category")
    })
    Product toProduct(ProductPromotionEntity productPromotionEntity);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(source = "idProduct", target = "id.idProduct"),
            @Mapping(target = "promotionEntity", ignore = true)
    })
    ProductPromotionEntity toProductPromotionEntity(Product product);


}
