package com.endava.store.storepets.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserTypeDto implements Serializable {

    private UUID id;
    @NotEmpty(message = "Id Number is mandatory")
    private String name;
    private String description;

}
