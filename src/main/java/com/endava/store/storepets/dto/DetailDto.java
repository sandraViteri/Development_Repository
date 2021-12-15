package com.endava.store.storepets.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DetailDto implements Serializable {

    private UUID id;

    @NotNull(message = "{validation.detailDto.invoice.empty}")
    private UUID invoice;

    @NotNull(message = "{validation.detailDto.product.empty}")
    private UUID product;

    @NotNull(message = "{validation.detailDto.amount.empty}")
    private int amount;

    @NotNull(message = "{validation.detailDto.value.empty}")
    private Double value;

}