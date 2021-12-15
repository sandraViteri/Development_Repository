package com.endava.store.storepets.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Date;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class InvoiceDto implements Serializable {

    private UUID id;

    @NotNull(message = "{validation.invoicesDto.user.empty}")
    private UUID user;

    @NotNull(message = "{validation.invoicesDto.paymentMode.empty}")
    private UUID paymentMode;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "America/Bogota")
    @NotNull(message = "{validation.invoicesDto.date.empty}")
    private Date date;

    @NotNull(message = "{validation.invoicesDto.totalValue.empty}")
    private Double totalValue;

    @NotNull(message = "{validation.invoicesDto.taxes.empty}")
    private Double taxes;

    @NotNull(message = "{validation.invoicesDto.discount.empty}")
    private Double discount;
}