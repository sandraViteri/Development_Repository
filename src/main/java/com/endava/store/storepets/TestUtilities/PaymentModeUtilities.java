package com.endava.store.storepets.TestUtilities;

import com.endava.store.storepets.dto.PaymentModeDto;
import com.endava.store.storepets.model.PaymentModeModel;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class PaymentModeUtilities {

    public static PaymentModeDto convertModelToPaymentModeDto(PaymentModeModel model) {
        return new PaymentModeDto(model.getId(), model.getName(), model.getDescription());
    }

    public static PaymentModeModel convertDtoToPaymentModeModel(PaymentModeDto dto) {
        return new PaymentModeModel(dto.getId(), dto.getName(),
                dto.getDescription());
    }

    public static List<PaymentModeDto> convertListModelToListDto(List<PaymentModeModel> listModel) {
        return listModel.stream().map(PaymentModeUtilities::convertModelToPaymentModeDto).collect(Collectors.toList());
    }

    public static List<PaymentModeModel> convertListDtoToListModel(List<PaymentModeDto> listDto) {
        return listDto.stream().map(PaymentModeUtilities::convertDtoToPaymentModeModel).collect(Collectors.toList());
    }
}
