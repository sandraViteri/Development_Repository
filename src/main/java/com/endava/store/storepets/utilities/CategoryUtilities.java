package com.endava.store.storepets.utilities;

import com.endava.store.storepets.dto.CategoryDto;
import com.endava.store.storepets.model.CategoryModel;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CategoryUtilities {

    public static CategoryDto convertModelToCategoryDto(CategoryModel model) {
        return new CategoryDto(model.getId(), model.getName(), model.getDescription());
    }

    public static CategoryModel convertDtoToCategoryModel(CategoryDto dto) {
        return new CategoryModel(dto.getId(), dto.getName(),
                dto.getDescription());
    }

    public static List<CategoryDto> convertListModelToListDto(List<CategoryModel> listModel) {
        return listModel.stream().map(CategoryUtilities::convertModelToCategoryDto).collect(Collectors.toList());
    }

    public static List<CategoryModel> convertListDtoToListModel(List<CategoryDto> listDto) {
        return listDto.stream().map(CategoryUtilities::convertDtoToCategoryModel).collect(Collectors.toList());
    }
}
