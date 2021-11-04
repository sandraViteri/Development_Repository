package com.endava.store.storepets.service;

import com.endava.store.storepets.dto.CategoryDto;
import com.endava.store.storepets.repository.CategoryRepository;
import com.endava.store.storepets.util.CategoryUtilities;
import com.endava.store.storepets.testUtilities.UtilityCategoryData;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class CategoryServiceTest {
    UtilityCategoryData util;

    @InjectMocks
    private CategoryService categoryService;
    @Mock
    private CategoryRepository categoryRepository;

    @Before
    public void setUp() {
        util = new UtilityCategoryData();
    }

    @Test
    public void testDtoEqualToModelWhenGetCategoryById() {
        Mockito.when(categoryRepository.getById(util.getCategoriesModel().get(1).getId()))
                .thenReturn(util.getCategoriesModel().get(1));

        CategoryDto dto = categoryService.getCategory(util.getCategoriesModel().get(1).getId());

        Assert.assertEquals("Not valid Description ", util.getCategoriesModel().get(1).getDescription(), dto.getDescription());
        Assert.assertEquals("Not valid Id ", util.getCategoriesModel().get(1).getId(), dto.getId());
        Assert.assertEquals("Not valid Name ", util.getCategoriesModel().get(1).getName(), dto.getName());
    }

    @Test
    public void testDtoListEqualToModelListWhenGetAllCategories() {
        Mockito.when(categoryRepository.findAll()).thenReturn(util.getCategoriesModel());

        List<CategoryDto> listDto = categoryService.getCategories();

        Assert.assertEquals("Not valid data ", util.getCategoriesModel().size(), listDto.size());
        Assert.assertEquals("Not valid data ", util.getCategoriesModel().get(util.getCategoriesModel().size() - 1).getId(),
                listDto.get(listDto.size() - 1).getId());
        Assert.assertEquals("Not valid data ", util.getCategoriesModel().get(util.getCategoriesModel().size() - 1).getName(),
                listDto.get(listDto.size() - 1).getName());
        Assert.assertEquals("Not valid data ", util.getCategoriesModel().get(util.getCategoriesModel().size() - 1).getDescription(),
                listDto.get(listDto.size() - 1).getDescription());
    }

    @Test
    public void testDtoListEqualToModelListWhenSaveCategories() {
        Mockito.when(categoryRepository.save(util.getCategoriesModel().get(1))).thenReturn(util.getCategoriesModel().get(1));

        CategoryDto dto = categoryService.saveCategory(new CategoryDto(util.getCategoriesModel().get(1).getId(),
                util.getCategoriesModel().get(1).getName(), util.getCategoriesModel().get(1).getDescription()));

        Assert.assertEquals("Not valid Description ", util.getCategoriesModel().get(1).getDescription(), dto.getDescription());
        Assert.assertEquals("Not valid Id ", util.getCategoriesModel().get(1).getId(), dto.getId());
        Assert.assertEquals("Not valid Name ", util.getCategoriesModel().get(1).getName(), dto.getName());

    }

    @Test
    public void testModelAndDtoFunctionalityUsingSaveCategory() {
        Mockito.when(categoryRepository.saveAll(util.getCategoriesModel())).thenReturn(util.getCategoriesModel());

        List<CategoryDto> listDto = categoryService.saveCategories(util.getCategoriesModel().stream()
                .map(CategoryUtilities::convertModelToCategoryDto)
                .collect(Collectors.toList()));

        Assert.assertEquals("Not valid data ", util.getCategoriesModel().size(), listDto.size());
        Assert.assertEquals("Not valid data ", util.getCategoriesModel().get(util.getCategoriesModel().size() - 1).getId(),
                listDto.get(listDto.size() - 1).getId());
        Assert.assertEquals("Not valid data ", util.getCategoriesModel().get(util.getCategoriesModel().size() - 1).getName(),
                listDto.get(listDto.size() - 1).getName());
        Assert.assertEquals("Not valid data ", util.getCategoriesModel().get(util.getCategoriesModel().size() - 1).getDescription(),
                listDto.get(listDto.size() - 1).getDescription());
    }

    @Test
    public void deleteCategory() {
    }
}