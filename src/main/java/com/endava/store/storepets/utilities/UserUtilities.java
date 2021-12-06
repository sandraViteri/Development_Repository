package com.endava.store.storepets.utilities;

import com.endava.store.storepets.dto.UserDto;
import com.endava.store.storepets.model.UserModel;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserUtilities {

    public static UserDto convertModelToUsersDto(UserModel model) {
        return new UserDto(model.getId(), model.getIdNumber(), model.getIdType(), model.getName(), model.getLastname(),
                model.getAddress(), model.getBirthdayDay(), model.getEmailAddress(), model.getType()
                , model.getPhone());
    }

    public static UserModel convertDtoToUsersModel(UserDto dto) {
        return new UserModel(dto.getId(), dto.getIdNumber(), dto.getIdType(), dto.getName(), dto.getLastname(),
                dto.getAddress(), dto.getBirthdayDay(), dto.getEmailAddress(), dto.getType()
                , dto.getPhone());
    }

    public static List<UserDto> convertListModelToListDto(List<UserModel> listModel) {
        return listModel.stream().map(UserUtilities::convertModelToUsersDto).collect(Collectors.toList());
    }

    public static List<UserModel> convertListDtoToListModel(List<UserDto> listDto) {
        return listDto.stream().map(UserUtilities::convertDtoToUsersModel).collect(Collectors.toList());
    }
}