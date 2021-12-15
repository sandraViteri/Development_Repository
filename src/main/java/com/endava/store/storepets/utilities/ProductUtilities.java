package com.endava.store.storepets.utilities;

import com.endava.store.storepets.dto.ProductDto;
import com.endava.store.storepets.model.ProductModel;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductUtilities {

    public static ProductDto convertModelToProductsDto(ProductModel model) {
        return new ProductDto(model.getId(), model.getName(), model.getDescription(), model.getColor(), model.getSize(),
                model.getValue(), model.getStock(), model.getCategory());
    }

    public static ProductModel convertDtoToProductsModel(ProductDto dto) {
        return new ProductModel(dto);
    }

    public static List<ProductDto> convertListModelToListDto(List<ProductModel> listModel) {
        return listModel.stream().map(ProductUtilities::convertModelToProductsDto).collect(Collectors.toList());
    }

    public static List<ProductModel> convertListDtoToListModel(List<ProductDto> listDto) {
        return listDto.stream().map(ProductUtilities::convertDtoToProductsModel).collect(Collectors.toList());
    }
}