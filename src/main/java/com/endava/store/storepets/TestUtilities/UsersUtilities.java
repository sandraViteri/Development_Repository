package com.endava.store.storepets.TestUtilities;

import com.endava.store.storepets.dto.UsersDto;
import com.endava.store.storepets.model.UsersModel;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UsersUtilities {


    public static UsersDto convertModelToUsersDto(UsersModel model) {
        return new UsersDto(model.getId(),model.getIdNumber(), model.getIdNumberType(), model.getName(),model.getLastname(),
                model.getAddress(), model.getBirthdayDay(),model.getEmailAddress(), model.getType()
                ,model.getPhone());
    }
    public static UsersModel convertDtoToUsersModel(UsersDto dto) {
        return new UsersModel(dto.getId(),dto.getIdNumber(), dto.getIdNumberType(), dto.getName(),dto.getLastname(),
                dto.getAddress(), dto.getBirthdayDay(),dto.getEmailAddress(), dto.getType()
                ,dto.getPhone());
    }


    public static List<UsersDto> convertListModelToListDto(List<UsersModel> listModel) {
         return listModel.stream().map(UsersUtilities::convertModelToUsersDto).collect(Collectors.toList());
    }

    public static List<UsersModel> convertListDtoToListModel(List<UsersDto> listDto) {
        return listDto.stream().map(UsersUtilities::convertDtoToUsersModel).collect(Collectors.toList());
    }


}

