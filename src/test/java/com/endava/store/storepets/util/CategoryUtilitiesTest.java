package com.endava.store.storepets.util;

import com.endava.store.storepets.dto.CategoryDto;
import com.endava.store.storepets.model.CategoryModel;
import com.endava.store.storepets.testUtilities.UtilityCategoryData;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class CategoryUtilitiesTest {

    @Test
    public void testConvertModelToCategoryDto() {
        CategoryModel model = UtilityCategoryData.getCategoriesModel().get(1);
        CategoryDto dto=CategoryUtilities.convertModelToCategoryDto(model);
        Assert.assertEquals("Not valid Description ", model.getDescription(), dto.getDescription());
        Assert.assertEquals("Not valid Id ", model.getId(), dto.getId());
        Assert.assertEquals("Not valid Name ", model.getName(), dto.getName());
    }

    @Test
    public void testConvertDtoToCategoryModel() {
        CategoryDto dto = UtilityCategoryData.getCategoriesDto().get(1);
        CategoryModel model = CategoryUtilities.convertDtoToCategoryModel(dto);
        Assert.assertEquals("Not valid Description ", dto.getDescription(), model.getDescription());
        Assert.assertEquals("Not valid Id ", dto.getId(), model.getId());
        Assert.assertEquals("Not valid Name ", dto.getName(), model.getName());
    }
}