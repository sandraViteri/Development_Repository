package com.endava.store.storepets.TestUtilities;

import com.endava.store.storepets.dto.UserTypeDto;
import com.endava.store.storepets.model.UserTypeModel;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class UserTypeUtilities {

    public static UserTypeDto convertModelToUserTypeDto(UserTypeModel model) {
        return new UserTypeDto(model.getId(), model.getName(), model.getDescription());
    }

    public static UserTypeModel convertDtoToUserTypeModel(UserTypeDto dto) {
        return new UserTypeModel(dto.getId(), dto.getName(),
                dto.getDescription());
    }

    public static List<UserTypeDto> convertListModelToListDto(List<UserTypeModel> listModel) {
        return listModel.stream().map(UserTypeUtilities::convertModelToUserTypeDto).collect(Collectors.toList());
    }

    public static List<UserTypeModel> convertListDtoToListModel(List<UserTypeDto> listDto) {
        return listDto.stream().map(UserTypeUtilities::convertDtoToUserTypeModel).collect(Collectors.toList());
    }
}
