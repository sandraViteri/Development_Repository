package com.endava.store.storepets.testutilities;

import com.endava.store.storepets.dto.UserTypeDto;
import com.endava.store.storepets.model.UserTypeModel;
import com.endava.store.storepets.testdata.UserTypeData;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class UserTypeUtilitiesTest {

    @Test
    public void testConvertModelToUserTypeDto() {
        UserTypeModel model = UserTypeData.getUserTypesModel().get(1);
        UserTypeDto dto=UserTypeUtilities.convertModelToUserTypeDto(model);
        Assert.assertEquals("Not valid Description ", model.getDescription(), dto.getDescription());
        Assert.assertEquals("Not valid Id ", model.getId(), dto.getId());
        Assert.assertEquals("Not valid Name ", model.getName(), dto.getName());
    }

    @Test
    public void testConvertDtoToUserTypeModel() {
        UserTypeDto dto = UserTypeData.getUserTypesDto().get(1);
        UserTypeModel model = UserTypeUtilities.convertDtoToUserTypeModel(dto);
        Assert.assertEquals("Not valid Description ", dto.getDescription(), model.getDescription());
        Assert.assertEquals("Not valid Id ", dto.getId(), model.getId());
        Assert.assertEquals("Not valid Name ", dto.getName(), model.getName());
    }
}