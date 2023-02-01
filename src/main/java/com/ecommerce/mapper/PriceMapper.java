package com.ecommerce.mapper;

import com.ecommerce.dto.PriceApi;
import com.ecommerce.model.Price;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PriceMapper {

    @Mapping(target= "brandId", source= "price.brand.id")
    PriceApi toPriceApi(final Price price);
}