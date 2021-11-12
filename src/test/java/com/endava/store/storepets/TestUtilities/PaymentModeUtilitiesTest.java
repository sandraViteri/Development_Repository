package com.endava.store.storepets.TestUtilities;

import com.endava.store.storepets.dto.PaymentModeDto;
import com.endava.store.storepets.model.PaymentModeModel;
import com.endava.store.storepets.testData.PaymentModeData;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class PaymentModeUtilitiesTest {

    @Test
    public void testConvertModelToPaymentModeDto() {
        PaymentModeModel model = PaymentModeData.getPaymentModesModel().get(1);
        PaymentModeDto dto=PaymentModeUtilities.convertModelToPaymentModeDto(model);
        Assert.assertEquals("Not valid Description ", model.getDescription(), dto.getDescription());
        Assert.assertEquals("Not valid Id ", model.getId(), dto.getId());
        Assert.assertEquals("Not valid Name ", model.getName(), dto.getName());
    }

    @Test
    public void testConvertDtoToPaymentModeModel() {
        PaymentModeDto dto = PaymentModeData.getPaymentModesDto().get(1);
        PaymentModeModel model = PaymentModeUtilities.convertDtoToPaymentModeModel(dto);
        Assert.assertEquals("Not valid Description ", dto.getDescription(), model.getDescription());
        Assert.assertEquals("Not valid Id ", dto.getId(), model.getId());
        Assert.assertEquals("Not valid Name ", dto.getName(), model.getName());
    }
}