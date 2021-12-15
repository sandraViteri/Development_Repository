package com.endava.store.storepets.dto;

import com.endava.store.storepets.utilities.validator.CurrentDateValidatorConstrain;
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

    @NotNull(message = "{validation.invoiceDto.user.empty}")
    private UUID user;

    @NotNull(message = "{validation.invoiceDto.paymentMode.empty}")
    private UUID paymentMode;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "America/Bogota")
    @NotNull(message = "{validation.invoiceDto.date.empty}")
    @CurrentDateValidatorConstrain(message = "{validation.invoiceDto.date.validate}")
    private Date date;

    @NotNull(message = "{validation.invoiceDto.totalValue.empty}")
    private Double totalValue;

    @NotNull(message = "{validation.invoiceDto.taxes.empty}")
    private Double taxes;

    @NotNull(message = "{validation.invoiceDto.discount.empty}")
    private Double discount;
}