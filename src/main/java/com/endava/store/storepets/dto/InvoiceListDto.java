package com.endava.store.storepets.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class InvoiceListDto {

    @Valid
    private List<InvoiceDto> invoices;

}
