package com.endava.store.storepets.service;

import com.endava.store.storepets.dto.CategoryDto;
import com.endava.store.storepets.model.CategoryModel;
import com.endava.store.storepets.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        return listObj.stream().map(categoryModel -> new CategoryDto(categoryModel.getId(), categoryModel.getName(),
                categoryModel.getDescription())).collect(Collectors.toList());
    }

    public List<CategoryDto> getCategory(UUID id) {
        List<CategoryDto> listDto = new ArrayList<>();
        CategoryModel obj = categoryRepository.getById(id);
        listDto.add(0, new CategoryDto(obj.getId(), obj.getName(), obj.getDescription()));
        return listDto;
    }

    public CategoryDto saveCategory(CategoryDto dto) {
        CategoryModel obj = new CategoryModel();
        obj.setId(dto.getId());
        obj.setName(dto.getName());
        obj.setDescription(dto.getDescription());
        obj = categoryRepository.save(obj);
        dto.setId(obj.getId());
        dto.setName(obj.getName());
        dto.setDescription(obj.getDescription());
        return dto;
    }

    public void deleteCategory(UUID id) {
        categoryRepository.deleteById(id);
    }
}

