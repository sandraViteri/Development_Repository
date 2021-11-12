package com.endava.store.storepets.testData;

import com.endava.store.storepets.dto.PaymentModeDto;
import com.endava.store.storepets.model.PaymentModeModel;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class PaymentModeData {

    public static List<PaymentModeModel> getPaymentModesModel() {
        List<PaymentModeModel> listModel = new ArrayList<>();
        listModel.add(0, new PaymentModeModel(UUID.fromString("09df742e-33a3-11ec-8f02-6949411d60df"),
                "testNameModelOne", "TestPaymentModeDescriptionModelOne"));
        listModel.add(1, new PaymentModeModel(UUID.fromString("09df742f-33a3-11ec-8f02-6949411d60df"),
                "testNameModelTwo", "TestPaymentModeDescriptionModelTwo"));
        return listModel;
    }

    public static List<PaymentModeDto> getPaymentModesDto() {
            List<PaymentModeDto> listDto = new ArrayList<>();
        listDto.add(0, new PaymentModeDto(UUID.fromString("09df742e-33a3-11ec-8f02-6949411d60df"),
                "testNameDtoOne", "TestPaymentModeDescriptionDtoOne"));
        listDto.add(1, new PaymentModeDto(UUID.fromString("09df742f-33a3-11ec-8f02-6949411d60df"),
                "testNameDtoTwo", "TestPaymentModeDescriptionDtoTwo"));
        return listDto;
    }
}
