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
        UtilityCategoryData obj = new UtilityCategoryData();

        CategoryDto dto = CategoryUtilities.convertModelToCategoryDto(obj.getCategoriesModel().get(1));

        Assert.assertEquals("Not valid Description ", obj.getCategoriesModel().get(1).getDescription()
                , dto.getDescription());
        Assert.assertEquals("Not valid Id ", obj.getCategoriesModel().get(1).getId(), dto.getId());
        Assert.assertEquals("Not valid Name ", obj.getCategoriesModel().get(1).getName(), dto.getName());
    }

    @Test
    public void testConvertDtoToCategoryModel() {
        UtilityCategoryData dto = new UtilityCategoryData();

        CategoryModel obj = CategoryUtilities.convertDtoToCategoryModel(dto.getCategoriesDto().get(1));

        Assert.assertEquals("Not valid Description ", dto.getCategoriesDto().get(1).getDescription()
                , obj.getDescription());
        Assert.assertEquals("Not valid Id ", dto.getCategoriesDto().get(1).getId(), obj.getId());
        Assert.assertEquals("Not valid Name ", dto.getCategoriesDto().get(1).getName(), obj.getName());
    }
}