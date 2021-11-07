package com.endava.store.storepets.service;

import com.endava.store.storepets.dto.UserTypeDto;
import com.endava.store.storepets.model.UserTypeModel;
import com.endava.store.storepets.repository.UserTypeRepository;
import com.endava.store.storepets.util.UserTypeUtilities;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserTypeService {

    @Autowired
    private UserTypeRepository userTypeRepository;

    public List<UserTypeDto> getUserTypes() {
        List<UserTypeModel> listModel = userTypeRepository.findAll();
        return UserTypeUtilities.convertListModelToListDto(listModel);
    }

    public UserTypeDto getUserType(UUID id) {
        UserTypeModel obj = userTypeRepository.getById(id);
        return UserTypeUtilities.convertModelToUserTypeDto(obj);
    }

    public List<UserTypeDto> saveUserTypes(List<UserTypeDto> listDto) {
        List<UserTypeModel> listModel = userTypeRepository.saveAll(
                UserTypeUtilities.convertListDtoToListModel(listDto));
        return UserTypeUtilities.convertListModelToListDto(listModel);
    }

    public void existUserType(UUID id) throws NotFoundException {
        if (!userTypeRepository.existsById(id)) {
            throw new NotFoundException("The UserType was not found!");
        }
    }

    public UserTypeDto updateUserType(UserTypeDto dto) throws NotFoundException {
        existUserType(dto.getId());
        UserTypeModel model = UserTypeUtilities.convertDtoToUserTypeModel(dto);
        return UserTypeUtilities.convertModelToUserTypeDto(userTypeRepository.save(model));
    }

    public void deleteUserType(UUID id) throws NotFoundException {
        existUserType(id);
        userTypeRepository.deleteById(id);
    }
}
