package com.endava.store.storepets.dto;

import com.endava.store.storepets.testutilities.validations.AgeValidatorConstrain;
import com.endava.store.storepets.testutilities.validations.IdTypeValidatorConstrain;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Date;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto implements Serializable {

    private UUID id;

    @Size(min = 5, max = 20, message = "{validation.usersDto.idNumber.size}")
    @NotEmpty(message = "{validation.usersDto.idNumber.empty")
    private String idNumber;

    @NotEmpty(message = "{validation.usersDto.idNumberType.empty}")
    @IdTypeValidatorConstrain(message = "{validation.usersDto.idNumberType.allowed}")
    private String idType;

    @NotEmpty(message = "{validation.usersDto.name.empty}")
    @Size(min = 1, max = 60, message = "{validation.usersDto.name.size}")
    private String name;

    @Size(min = 1, max = 60, message = "{validation.usersDto.lastName.size}")
    @NotEmpty(message = "{validation.usersDto.lastName.empty}")
    private String lastname;

    @Size(min = 1, max = 100, message = "{validation.usersDto.address.size}")
    @NotEmpty(message = "{validation.usersDto.address.empty}")
    private String address;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "America/Bogota")
    @NotNull(message = "{validation.usersDto.birthdayDate.empty}")
    @AgeValidatorConstrain(message = "{validation.usersDto.birthdayDate.age}")
    private Date birthdayDay;

    @Email(message = "{validation.usersDto.emailAddress.size}")
    private String emailAddress;

    @NotNull(message = "{validation.usersDto.type.empty}")
    private UUID type;

    @Size(min = 10, max = 10, message = "{validation.usersDto.phone.size}")
    private String phone;

}