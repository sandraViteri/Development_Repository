package com.endava.store.storepets.service;

import com.endava.store.storepets.TestUtilities.UsersUtilities;
import com.endava.store.storepets.dto.UsersDto;
import com.endava.store.storepets.model.UsersModel;
import com.endava.store.storepets.repository.UsersRepository;
import com.endava.store.storepets.testData.UsersData;
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
public class UsersServiceTest {

    @InjectMocks
    private UsersService usersService;
    @Mock
    private UsersRepository usersRepository;

    List<UsersModel> listModel;

    @Before
    public void setUp(){
        listModel = UsersData.getUsersModel();
    }

    @Test
    public void testDtoEqualToModelWhenGetUserById() {
        Mockito.when(usersRepository.getById(listModel.get(1).getId())).thenReturn(listModel.get(1));

        UsersDto dto = usersService.getUser(listModel.get(1).getId());

        Assert.assertEquals("Not valid Id ", listModel.get(1).getId(), dto.getId());
        Assert.assertEquals("Not valid Id Number", listModel.get(1).getIdNumber(), dto.getIdNumber());
        Assert.assertEquals("Not valid Id NumberType ", listModel.get(1).getIdNumberType(), dto.getIdNumberType());
        Assert.assertEquals("Not valid Name ", listModel.get(1).getName(), dto.getName());
        Assert.assertEquals("Not valid Last name ", listModel.get(1).getLastname(), dto.getLastname());
        Assert.assertEquals("Not valid Address ", listModel.get(1).getAddress(), dto.getAddress());
        Assert.assertEquals("Not valid Birthday Day ", listModel.get(1).getBirthdayDay(), dto.getBirthdayDay());
        Assert.assertEquals("Not valid Email Address ", listModel.get(1).getEmailAddress(), dto.getEmailAddress());
        Assert.assertEquals("Not valid Type ", listModel.get(1).getType(), dto.getType());
        Assert.assertEquals("Not valid Phone ", listModel.get(1).getPhone(), dto.getPhone());
    }

    @Test
    public void testDtoEqualToModelWhenGetUsers() {
        Mockito.when(usersRepository.findAll()).thenReturn(listModel);

        List<UsersDto> listDto = usersService.getUsers();

        Assert.assertEquals("The data size does not match with expected data size",
                listModel.size(), listDto.size());
        Assert.assertEquals("Not valid Id ", listModel.get(listModel.size() - 1).getId(),
                listDto.get(listDto.size() - 1).getId());
        Assert.assertEquals("Not valid Id Number", listModel.get(listModel.size() - 1).getIdNumber(),
                listDto.get(listDto.size() - 1).getIdNumber());
        Assert.assertEquals("Not valid Id NumberType ", listModel.get(listModel.size() - 1).getIdNumberType(),
                listDto.get(listDto.size() - 1).getIdNumberType());
        Assert.assertEquals("Not valid Name ", listModel.get(listModel.size() - 1).getName(),
                listDto.get(listDto.size() - 1).getName());
        Assert.assertEquals("Not valid Last name ", listModel.get(listModel.size() - 1).getLastname(),
                listDto.get(listDto.size() - 1).getLastname());
        Assert.assertEquals("Not valid Address ", listModel.get(listModel.size() - 1).getAddress(),
               listDto.get(listDto.size() - 1).getAddress());
        Assert.assertEquals("Not valid Birthday Day ", listModel.get(listModel.size() - 1).getBirthdayDay(),
                listDto.get(listDto.size() - 1).getBirthdayDay());
        Assert.assertEquals("Not valid Email Address ", listModel.get(listModel.size() - 1).getEmailAddress(),
                listDto.get(listDto.size() - 1).getEmailAddress());
        Assert.assertEquals("Not valid Type ", listModel.get(listModel.size() - 1).getType(),
                listDto.get(listDto.size() - 1).getType());
        Assert.assertEquals("Not valid Phone ", listModel.get(listModel.size() - 1).getPhone(),
                listDto.get(listDto.size() - 1).getPhone());
    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();
    @Test
    public void testModelAndDtoFunctionalityUsingSaveUsers() {
        Mockito.when(usersRepository.saveAll(listModel)).thenReturn(listModel);

        List<UsersDto> listDto = usersService.saveUsers(UsersUtilities.convertListModelToListDto(listModel));

        Assert.assertEquals("The data size does not match with expected data size",
                listModel.size(), listDto.size());
        Assert.assertEquals("Not valid Id ", listModel.get(listModel.size() - 1).getId(),
                listDto.get(listDto.size() - 1).getId());
        Assert.assertEquals("Not valid Id Number", listModel.get(listModel.size() - 1).getIdNumber(),
                listDto.get(listDto.size() - 1).getIdNumber());
        Assert.assertEquals("Not valid Id NumberType ", listModel.get(listModel.size() - 1).getIdNumberType(),
                listDto.get(listDto.size() - 1).getIdNumberType());
        Assert.assertEquals("Not valid Name ", listModel.get(listModel.size() - 1).getName(),
                listDto.get(listDto.size() - 1).getName());
        Assert.assertEquals("Not valid Last name ", listModel.get(listModel.size() - 1).getLastname(),
                listDto.get(listDto.size() - 1).getLastname());
        Assert.assertEquals("Not valid Address ", listModel.get(listModel.size() - 1).getAddress(),
                listDto.get(listDto.size() - 1).getAddress());
        Assert.assertEquals("Not valid Birthday Day ", listModel.get(listModel.size() - 1).getBirthdayDay(),
                listDto.get(listDto.size() - 1).getBirthdayDay());
        Assert.assertEquals("Not valid Email Address ", listModel.get(listModel.size() - 1).getEmailAddress(),
                listDto.get(listDto.size() - 1).getEmailAddress());
        Assert.assertEquals("Not valid Type ", listModel.get(listModel.size() - 1).getType(),
                listDto.get(listDto.size() - 1).getType());
        Assert.assertEquals("Not valid Phone ", listModel.get(listModel.size() - 1).getPhone(),
                listDto.get(listDto.size() - 1).getPhone());
    }
   }