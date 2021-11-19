package com.endava.store.storepets.testdata;

import com.endava.store.storepets.dto.UserTypeDto;
import com.endava.store.storepets.model.UserTypeModel;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class UserTypeData {

    public static List<UserTypeModel> getUserTypesModel() {
        List<UserTypeModel> listModel = new ArrayList<>();
        listModel.add(0, new UserTypeModel(UUID.fromString("09df742e-33a3-11ec-8f02-6949411d60df"),
                "testNameModelOne", "TestUserTypeDescriptionModelOne"));
        listModel.add(1, new UserTypeModel(UUID.fromString("09df742f-33a3-11ec-8f02-6949411d60df"),
                "testNameModelTwo", "TestUserTypeDescriptionModelTwo"));
        return listModel;
    }

    public static List<UserTypeDto> getUserTypesDto() {
        List<UserTypeDto> listDto = new ArrayList<>();
        listDto.add(0, new UserTypeDto(UUID.fromString("09df742e-33a3-11ec-8f02-6949411d60df"),
                "testNameDtoOne", "TestUserTypeDescriptionDtoOne"));
        listDto.add(1, new UserTypeDto(UUID.fromString("09df742f-33a3-11ec-8f02-6949411d60df"),
                "testNameDtoTwo", "TestUserTypeDescriptionDtoTwo"));
        return listDto;
    }
}
