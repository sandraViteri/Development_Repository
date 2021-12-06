package com.endava.store.storepets.service;

import com.endava.store.storepets.dto.UserDto;
import com.endava.store.storepets.model.UserModel;
import com.endava.store.storepets.repository.UserRepository;
import com.endava.store.storepets.testdata.UsersData;
import com.endava.store.storepets.utilities.UserUtilities;
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
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.Example;

import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class UserServiceTest {

    @InjectMocks
    private UserService userService;
    @Mock
    private UserRepository userRepository;

    private List<UserModel> listModel;

    @Before
    public void setUp(){
        listModel = UsersData.getUsersModel();
    }

    @Test
    public void testDtoEqualToModelWhenGetUserById() {
        Mockito.when(userRepository.getById(listModel.get(1).getId())).thenReturn(listModel.get(1));

        UserDto dto = userService.getUser(listModel.get(1).getId());

        Assert.assertEquals("Not valid Id ", listModel.get(1).getId(), dto.getId());
        Assert.assertEquals("Not valid Id Number", listModel.get(1).getIdNumber(), dto.getIdNumber());
        Assert.assertEquals("Not valid Id NumberType ", listModel.get(1).getIdType(), dto.getIdType());
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
        Mockito.when(userRepository.findAll()).thenReturn(listModel);

        List<UserDto> listDto = userService.getUsers();

        Assert.assertEquals("The data size does not match with expected data size",
                listModel.size(), listDto.size());
        Assert.assertEquals("Not valid Id ", listModel.get(listModel.size() - 1).getId(),
                listDto.get(listDto.size() - 1).getId());
        Assert.assertEquals("Not valid Id Number", listModel.get(listModel.size() - 1).getIdNumber(),
                listDto.get(listDto.size() - 1).getIdNumber());
        Assert.assertEquals("Not valid Id NumberType ", listModel.get(listModel.size() - 1).getIdType(),
                listDto.get(listDto.size() - 1).getIdType());
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
    @Test
    public void testDtoListEqualToModelListWhenUpdateUsers() throws NotFoundException {
        Mockito.when(userRepository.existsById(listModel.get(1).getId())).thenReturn(true);
        Mockito.when(userRepository.save(listModel.get(1))).thenReturn(listModel.get(1));

        UserDto dto = userService.updateUsers(new UserDto(listModel.get(1).getId(),
                listModel.get(1).getIdNumber(),
                listModel.get(1).getIdType(),
                listModel.get(1).getName(),
                listModel.get(1).getLastname(),
                listModel.get(1).getAddress(),
                listModel.get(1).getBirthdayDay(),
                listModel.get(1).getEmailAddress(),
                listModel.get(1).getType(),
                listModel.get(1).getPhone()));

        Assert.assertEquals("Not valid Id ", listModel.get(1).getId(), dto.getId());
        Assert.assertEquals("Not valid Id Number", listModel.get(1).getIdNumber(), dto.getIdNumber());
        Assert.assertEquals("Not valid Id NumberType ", listModel.get(1).getIdType(), dto.getIdType());
        Assert.assertEquals("Not valid Name ", listModel.get(1).getName(), dto.getName());
        Assert.assertEquals("Not valid Last name ", listModel.get(1).getLastname(), dto.getLastname());
        Assert.assertEquals("Not valid Address ", listModel.get(1).getAddress(), dto.getAddress());
        Assert.assertEquals("Not valid Birthday Day ", listModel.get(1).getBirthdayDay(), dto.getBirthdayDay());
        Assert.assertEquals("Not valid Email Address ", listModel.get(1).getEmailAddress(), dto.getEmailAddress());
        Assert.assertEquals("Not valid Type ", listModel.get(1).getType(), dto.getType());
        Assert.assertEquals("Not valid Phone ", listModel.get(1).getPhone(), dto.getPhone());
    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();
    @Test
    public void testModelAndDtoFunctionalityWhenSaveUsers(){
        Mockito.when(userRepository.saveAll(listModel)).thenReturn(listModel);

        List<UserDto> listDto = userService.saveUsers(UserUtilities.convertListModelToListDto(listModel));

        Assert.assertEquals("The data size does not match with expected data size",
                listModel.size(), listDto.size());
        Assert.assertEquals("Not valid Id ", listModel.get(listModel.size() - 1).getId(),
                listDto.get(listDto.size() - 1).getId());
        Assert.assertEquals("Not valid Id Number", listModel.get(listModel.size() - 1).getIdNumber(),
                listDto.get(listDto.size() - 1).getIdNumber());
        Assert.assertEquals("Not valid Id NumberType ", listModel.get(listModel.size() - 1).getIdType(),
                listDto.get(listDto.size() - 1).getIdType());
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

    @Test
    public void testDeleteUser() throws NotFoundException {
        Mockito.when(userRepository.existsById(listModel.get(1).getId())).thenReturn(true);
        userService.deleteUser(listModel.get(1).getId());

        verify(userRepository, times(1)).deleteById(listModel.get(1).getId());
    }

    @Test
    public void testWhenDeleteUserTypeExceptionIsThrown() throws NotFoundException {
        exceptionRule.expect(NotFoundException.class);
        exceptionRule.expectMessage("The User was not found!");
        Mockito.when(userRepository.existsById(listModel.get(1).getId())).thenReturn(false);
        userService.deleteUser(listModel.get(1).getId());
    }

    @Test
    public void testWhenExistUserByIdNumberExceptionIsThrown() throws DuplicateKeyException {
        exceptionRule.expect(DuplicateKeyException.class);
        exceptionRule.expectMessage(String.format("The user %s already exist!", listModel.get(1).getIdNumber()));
        UserModel model= new UserModel();
        model.setIdNumber("1113519304");
        Example<UserModel> example = Example.of(model);
        Mockito.when(userRepository.findAll(example)).thenReturn(listModel);
        userService.existUserByIdNumber(listModel.get(1).getIdNumber());
    }

    @Test
    public void existUserByIdNumber() throws DuplicateKeyException {
        userService.existUserByIdNumber(listModel.get(1).getIdNumber());
        UserModel model= new UserModel();
        model.setIdNumber(listModel.get(1).getIdNumber());
        Example<UserModel> example = Example.of(model);
        verify(userRepository, times(1)).findAll(example);
    }
}