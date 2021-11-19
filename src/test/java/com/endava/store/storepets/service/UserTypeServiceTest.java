package com.endava.store.storepets.service;

import com.endava.store.storepets.dto.UserTypeDto;
import com.endava.store.storepets.model.UserTypeModel;
import com.endava.store.storepets.repository.UserTypeRepository;
import com.endava.store.storepets.testdata.UserTypeData;
import com.endava.store.storepets.testutilities.UserTypeUtilities;
import javassist.NotFoundException;
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

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class UserTypeServiceTest {

    @InjectMocks
    private UserTypeService userTypeService;
    @Mock
    private UserTypeRepository userTypeRepository;

    List<UserTypeModel> listModel;

    @Before
    public void setUp(){
        listModel = UserTypeData.getUserTypesModel();
    }

    @Test
    public void testDtoEqualToModelWhenGetUserTypeById() {
        Mockito.when(userTypeRepository.getById(listModel.get(1).getId())).thenReturn(listModel.get(1));

        UserTypeDto dto = userTypeService.getUserType(listModel.get(1).getId());

        Assert.assertEquals("Not valid Id ", listModel.get(1).getId(), dto.getId());
        Assert.assertEquals("Not valid Name ", listModel.get(1).getName(), dto.getName());
        Assert.assertEquals("Not valid Description ", listModel.get(1).getDescription(), dto.getDescription());
    }

    @Test
    public void testDtoListEqualToModelListWhenGetAllUserTypes() {
        Mockito.when(userTypeRepository.findAll()).thenReturn(listModel);

        List<UserTypeDto> listDtoResult = userTypeService.getUserTypes();

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
    public void testDtoListEqualToModelListWhenUpdateUserType() throws NotFoundException {
        Mockito.when(userTypeRepository.existsById(listModel.get(1).getId())).thenReturn(true);
        Mockito.when(userTypeRepository.save(listModel.get(1))).thenReturn(listModel.get(1));

        UserTypeDto dto = userTypeService.updateUserType(new UserTypeDto(listModel.get(1).getId(),
                listModel.get(1).getName(), listModel.get(1).getDescription()));

        Assert.assertEquals("Not valid Id ", listModel.get(1).getId(), dto.getId());
        Assert.assertEquals("Not valid Name ", listModel.get(1).getName(), dto.getName());
        Assert.assertEquals("Not valid Description ", listModel.get(1).getDescription(), dto.getDescription());
    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();
    @Test
    public void testModelAndDtoFunctionalityUsingSaveUserTypes() {
        Mockito.when(userTypeRepository.saveAll(listModel)).thenReturn(listModel);

        List<UserTypeDto> listDto = userTypeService.saveUserTypes(
                UserTypeUtilities.convertListModelToListDto(listModel));

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
    public void testWhenDeleteUserTypeExceptionIsThrown() throws NotFoundException {
        exceptionRule.expect(NotFoundException.class);
        exceptionRule.expectMessage("The User Type was not found!");
        Mockito.when(userTypeRepository.existsById(listModel.get(1).getId())).thenReturn(false);
        userTypeService.deleteUserType(listModel.get(1).getId());
    }

    @Test
    public void testDeleteUser() throws NotFoundException {
        Mockito.when(userTypeRepository.existsById(listModel.get(1).getId())).thenReturn(true);
        userTypeService.deleteUserType(listModel.get(1).getId());

        verify(userTypeRepository, times(1)).deleteById(listModel.get(1).getId());
    }

}