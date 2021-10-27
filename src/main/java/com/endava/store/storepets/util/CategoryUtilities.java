package com.endava.store.storepets.util;

import com.endava.store.storepets.dto.CategoryDto;
import com.endava.store.storepets.model.CategoryModel;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CategoryUtilities {

    public static CategoryDto convertModelToCategoryDto(CategoryModel obj){
        return new CategoryDto(obj.getId(), obj.getName(), obj.getDescription());
    }

    public static CategoryModel convertDtoToCategoryModel(CategoryDto dto){
        return new CategoryModel(dto.getId(), dto.getName(),
                dto.getDescription());
    }
}
