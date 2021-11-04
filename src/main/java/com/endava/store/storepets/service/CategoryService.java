package com.endava.store.storepets.service;

import com.endava.store.storepets.dto.CategoryDto;
import com.endava.store.storepets.model.CategoryModel;
import com.endava.store.storepets.repository.CategoryRepository;
import com.endava.store.storepets.util.CategoryUtilities;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CategoryService {

    @Autowired
    private final CategoryRepository categoryRepository;

    public List<CategoryDto> getCategories() {
        List<CategoryModel> listObj = categoryRepository.findAll();
        return listObj.stream().map(CategoryUtilities::convertModelToCategoryDto).collect(Collectors.toList());
    }

    public CategoryDto getCategory(UUID id) {
        CategoryModel obj = categoryRepository.getById(id);
        return CategoryUtilities.convertModelToCategoryDto(obj);
    }

    public List<CategoryDto> saveCategories(List<CategoryDto> listDto) {
        List<CategoryModel> listModel = categoryRepository.saveAll(listDto.stream()
                .map(CategoryUtilities::convertDtoToCategoryModel)
                .collect(Collectors.toList()));
        return listModel.stream()
                .map(CategoryUtilities::convertModelToCategoryDto)
                .collect(Collectors.toList());
    }

    public CategoryDto saveCategory(CategoryDto dto) {
        CategoryModel model = categoryRepository.save(CategoryUtilities.convertDtoToCategoryModel(dto));
        return CategoryUtilities.convertModelToCategoryDto(model);
    }

    public void deleteCategory(UUID id) {
        categoryRepository.deleteById(id);
    }
}

