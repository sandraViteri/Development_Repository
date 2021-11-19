package com.endava.store.storepets.service;

import com.endava.store.storepets.dto.CategoryDto;
import com.endava.store.storepets.model.CategoryModel;
import com.endava.store.storepets.repository.CategoryRepository;
import com.endava.store.storepets.testutilities.CategoryUtilities;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CategoryService extends GenericService{

    @Autowired
    private CategoryRepository categoryRepository;

    public List<CategoryDto> getCategories() {
        List<CategoryModel> listModel = categoryRepository.findAll();
        return CategoryUtilities.convertListModelToListDto(listModel);
    }

    public CategoryDto getCategory(UUID id) {
        CategoryModel obj = categoryRepository.getById(id);
        return CategoryUtilities.convertModelToCategoryDto(obj);
    }

    public List<CategoryDto> saveCategories(List<CategoryDto> listDto) {
        List<CategoryModel> listModel = categoryRepository.saveAll(
                CategoryUtilities.convertListDtoToListModel(listDto));
        return CategoryUtilities.convertListModelToListDto(listModel);
    }

    public CategoryDto updateCategory(CategoryDto dto) throws NotFoundException {
        exist(categoryRepository,dto.getId(),"Category");
        CategoryModel model = CategoryUtilities.convertDtoToCategoryModel(dto);
        return CategoryUtilities.convertModelToCategoryDto(categoryRepository.save(model));
    }

    public void deleteCategory(UUID id) throws NotFoundException {
        delete(categoryRepository,id, "Category");
    }
}

