package com.endava.store.storepets.utilities;

import com.endava.store.storepets.dto.InvoiceDto;
import com.endava.store.storepets.model.InvoiceModel;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class InvoiceUtilities {

    public static InvoiceDto convertModelToInvoicesDto(InvoiceModel model) {
        return new InvoiceDto(model.getId(), model.getUser(), model.getPaymentMode(), model.getDate(),
                model.getTotalValue(),model.getTaxes(),model.getDiscount());
    }

    public static InvoiceModel convertDtoToInvoicesModel(InvoiceDto dto) {
        return new InvoiceModel(dto.getId(), dto.getUser(), dto.getPaymentMode(), dto.getDate(), dto.getTotalValue(),
                dto.getTaxes(), dto.getDiscount());
    }

    public static List<InvoiceDto> convertListModelToListDto(List<InvoiceModel> listModel) {
        return listModel.stream().map(InvoiceUtilities::convertModelToInvoicesDto).collect(Collectors.toList());
    }

    public static List<InvoiceModel> convertListDtoToListModel(List<InvoiceDto> listDto) {
        return listDto.stream().map(InvoiceUtilities::convertDtoToInvoicesModel).collect(Collectors.toList());
    }
}