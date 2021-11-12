package com.endava.store.storepets.service;

import com.endava.store.storepets.TestUtilities.UsersUtilities;
import com.endava.store.storepets.dto.UsersDto;
import com.endava.store.storepets.model.UsersModel;
import com.endava.store.storepets.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    public List<UsersDto> getUsers() {
        List<UsersModel> listModel = usersRepository.findAll();
        return UsersUtilities.convertListModelToListDto(listModel);
    }

    public UsersDto getUser(UUID id) {
        UsersModel model = usersRepository.getById(id);
        return UsersUtilities.convertModelToUsersDto(model);
    }

    public List<UsersDto> saveUsers(List<UsersDto> listDto) {
        List<UsersModel> listModel = usersRepository.saveAll(UsersUtilities.convertListDtoToListModel(listDto));
        return UsersUtilities.convertListModelToListDto(listModel);
    }
}
