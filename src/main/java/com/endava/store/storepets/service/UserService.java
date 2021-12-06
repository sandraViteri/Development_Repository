package com.endava.store.storepets.service;

import com.endava.store.storepets.constants.Constants;
import com.endava.store.storepets.dto.UserDto;
import com.endava.store.storepets.model.UserModel;
import com.endava.store.storepets.repository.UserRepository;
import com.endava.store.storepets.utilities.UserUtilities;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService extends GenericService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDto> getUsers() {
        List<UserModel> listModel = userRepository.findAll();
        return UserUtilities.convertListModelToListDto(listModel);
    }

    public UserDto getUser(UUID id) {
        UserModel model = userRepository.getById(id);
        return UserUtilities.convertModelToUsersDto(model);
    }

    public List<UserDto> saveUsers(List<UserDto> listDto) throws DuplicateKeyException {
        for (UserDto userDto:listDto){
                existUserByIdNumber(userDto.getIdNumber());
         }
        List<UserModel> listModel = userRepository.saveAll(UserUtilities.convertListDtoToListModel(listDto));
        return UserUtilities.convertListModelToListDto(listModel);
    }

    public void existUserByIdNumber(String idNumber) throws DuplicateKeyException {
        UserModel model= new UserModel();
        model.setIdNumber(idNumber);
        Example<UserModel> example = Example.of(model);

        if (!userRepository.findAll(example).isEmpty()) {
            throw new DuplicateKeyException(String.format(Constants.USER_ALREADY_EXIST_MESSAGE, idNumber));
        }
    }

    public UserDto updateUsers(UserDto dto) throws NotFoundException {
        exist(userRepository,dto.getId(),Constants.USER);
        UserModel model = UserUtilities.convertDtoToUsersModel(dto);
        return UserUtilities.convertModelToUsersDto(userRepository.save(model));
    }

    public void deleteUser(UUID id) throws NotFoundException {
        delete(userRepository,id,Constants.USER);
    }
}
