package com.endava.store.storepets.testdata;

import com.endava.store.storepets.dto.CategoryDto;
import com.endava.store.storepets.model.CategoryModel;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CategoryData {

    public static List<CategoryModel> getCategoriesModel() {
        List<CategoryModel> listModel = new ArrayList<>();
        listModel.add(0, new CategoryModel(UUID.fromString("6d0925fc-7d89-491f-b76b-96d9f9146824"),
                "testNameModelOne", "TestCategoryDescriptionModelOne"));
        listModel.add(1, new CategoryModel(UUID.fromString("6d0925fc-7d89-491f-b76b-96d9f9146523"),
                "testNameModelTwo", "TestCategoryDescriptionModelTwo"));
        return listModel;
    }

    public static List<CategoryDto> getCategoriesDto() {
        List<CategoryDto> listDto = new ArrayList<>();
        listDto.add(0, new CategoryDto(UUID.fromString("6d0925fc-7d89-491f-b76b-96d9f9146222"),
                "testNameDtoOne", "TestCategoryDescriptionDtoOne"));
        listDto.add(1, new CategoryDto(UUID.fromString("6d0925fc-7d89-491f-b76b-96d9f9146432"),
                "testNameDtoTwo", "TestCategoryDescriptionDtoTwo"));
        return listDto;
    }
}
