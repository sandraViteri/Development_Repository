package com.endava.store.storepets.service;

import com.endava.store.storepets.dto.CategoryDto;
import com.endava.store.storepets.model.CategoryModel;
import com.endava.store.storepets.repository.CategoryRepository;
import com.endava.store.storepets.testUtilities.UtilityCategoryData;
import com.endava.store.storepets.util.CategoryUtilities;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class CategoryServiceTest {

    @InjectMocks
    private CategoryService categoryService;
    @Mock
    private CategoryRepository categoryRepository;

    List<CategoryModel> listModel;

    @Before
    public void setUp(){
        listModel = UtilityCategoryData.getCategoriesModel();
    }

    @Test
    public void testDtoEqualToModelWhenGetCategoryById() {
        Mockito.when(categoryRepository.getById(listModel.get(1).getId())).thenReturn(listModel.get(1));

        CategoryDto dto = categoryService.getCategory(listModel.get(1).getId());

        Assert.assertEquals("Not valid Id ", listModel.get(1).getId(), dto.getId());
        Assert.assertEquals("Not valid Name ", listModel.get(1).getName(), dto.getName());
        Assert.assertEquals("Not valid Description ", listModel.get(1).getDescription(), dto.getDescription());
    }

    @Test
    public void testDtoListEqualToModelListWhenGetAllCategories() {
        Mockito.when(categoryRepository.findAll()).thenReturn(listModel);

        List<CategoryDto> listDtoResult = categoryService.getCategories();

        Assert.assertEquals("The data size does not match with expected data size", listModel.size()
                , listDtoResult.size());
        Assert.assertEquals("Not valid Id", listModel.get(listModel.size() - 1).getId(),
                listDtoResult.get(listDtoResult.size() - 1).getId());
        Assert.assertEquals("Not valid Name ", listModel.get(listModel.size() - 1).getName(),
                listDtoResult.get(listDtoResult.size() - 1).getName());
        Assert.assertEquals("Not valid data ", listModel.get(listModel.size() - 1).getDescription(),
                listDtoResult.get(listDtoResult.size() - 1).getDescription());
    }

    @Test
    public void testDtoListEqualToModelListWhenUpdateCategory() throws Exception {
        Mockito.when(categoryRepository.existsById(listModel.get(1).getId())).thenReturn(true);
        Mockito.when(categoryRepository.save(listModel.get(1))).thenReturn(listModel.get(1));

        CategoryDto dto = categoryService.updateCategory(new CategoryDto(listModel.get(1).getId(),
                listModel.get(1).getName(), listModel.get(1).getDescription()));

        Assert.assertEquals("Not valid Id ", listModel.get(1).getId(), dto.getId());
        Assert.assertEquals("Not valid Name ", listModel.get(1).getName(), dto.getName());
        Assert.assertEquals("Not valid Description ", listModel.get(1).getDescription(), dto.getDescription());
    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();
    @Test
    public void testWhenCategoryDoesNotExistExceptionIsThrown() throws Exception {
        exceptionRule.expect(Exception.class);
        exceptionRule.expectMessage("The Category was not found!");
        Mockito.when(categoryRepository.existsById(listModel.get(1).getId())).thenReturn(false);
        categoryService.existCategory(listModel.get(1).getId());
    }

    @Test
    public void testModelAndDtoFunctionalityUsingSaveCategories() {
        Mockito.when(categoryRepository.saveAll(listModel)).thenReturn(listModel);

        List<CategoryDto> listDto = categoryService.saveCategories(
                CategoryUtilities.convertListModelToListDto(listModel));

        Assert.assertEquals("The data size does not match with expected data size",
                listModel.size(), listDto.size());
        Assert.assertEquals("Not valid Id ", listModel.get(listModel.size() - 1).getId(),
                listDto.get(listDto.size() - 1).getId());
        Assert.assertEquals("Not valid Name ", listModel.get(listModel.size() - 1).getName(),
                listDto.get(listDto.size() - 1).getName());
        Assert.assertEquals("Not valid Description ", listModel.get(listModel.size() - 1).getDescription(),
                listDto.get(listDto.size() - 1).getDescription());
    }

    @Test
    public void testWhenDeleteCategoryExceptionIsThrown() throws Exception {
        exceptionRule.expect(Exception.class);
        exceptionRule.expectMessage("The Category was not found!");
        Mockito.when(categoryRepository.existsById(listModel.get(1).getId())).thenReturn(false);
        categoryService.deleteCategory(listModel.get(1).getId());
    }
}