package com.endava.store.storepets.service;

import com.endava.store.storepets.dto.PaymentModeDto;
import com.endava.store.storepets.model.PaymentModeModel;
import com.endava.store.storepets.repository.PaymentModeRepository;
import com.endava.store.storepets.testData.PaymentModeData;
import com.endava.store.storepets.TestUtilities.PaymentModeUtilities;
import javassist.NotFoundException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class PaymentModeServiceTest {

    @InjectMocks
    private PaymentModeService paymentModeService;
    @Mock
    private PaymentModeRepository paymentModeRepository;

    List<PaymentModeModel> listModel;

    @Before
    public void setUp(){
        listModel = PaymentModeData.getPaymentModesModel();
    }

    @Test
    public void testDtoEqualToModelWhenGetPaymentModeById() {
        Mockito.when(paymentModeRepository.getById(listModel.get(1).getId())).thenReturn(listModel.get(1));

        PaymentModeDto dto = paymentModeService.getPaymentMode(listModel.get(1).getId());

        Assert.assertEquals("Not valid Id ", listModel.get(1).getId(), dto.getId());
        Assert.assertEquals("Not valid Name ", listModel.get(1).getName(), dto.getName());
        Assert.assertEquals("Not valid Description ", listModel.get(1).getDescription(), dto.getDescription());
    }

    @Test
    public void testDtoListEqualToModelListWhenGetAllPaymentModes() {
        Mockito.when(paymentModeRepository.findAll()).thenReturn(listModel);

        List<PaymentModeDto> listDtoResult = paymentModeService.getPaymentModes();

        Assert.assertEquals("The data size does not match with expected data size", listModel.size()
                , listDtoResult.size());
        Assert.assertEquals("Not valid Id", listModel.get(listModel.size() - 1).getId(),
                listDtoResult.get(listDtoResult.size() - 1).getId());
        Assert.assertEquals("Not valid Name ", listModel.get(listModel.size() - 1).getName(),
                listDtoResult.get(listDtoResult.size() - 1).getName());
        Assert.assertEquals("Not valid data ", listModel.get(listModel.size() - 1).getDescription(),
                listDtoResult.get(listDtoResult.size() - 1).getDescription());
    }

    @Test
    public void testDtoListEqualToModelListWhenUpdatePaymentMode() throws NotFoundException {
        Mockito.when(paymentModeRepository.existsById(listModel.get(1).getId())).thenReturn(true);
        Mockito.when(paymentModeRepository.save(listModel.get(1))).thenReturn(listModel.get(1));

        PaymentModeDto dto = paymentModeService.updatePaymentMode(new PaymentModeDto(listModel.get(1).getId(),
                listModel.get(1).getName(), listModel.get(1).getDescription()));

        Assert.assertEquals("Not valid Id ", listModel.get(1).getId(), dto.getId());
        Assert.assertEquals("Not valid Name ", listModel.get(1).getName(), dto.getName());
        Assert.assertEquals("Not valid Description ", listModel.get(1).getDescription(), dto.getDescription());
    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();
     @Test
    public void testModelAndDtoFunctionalityUsingSavePaymentModes() {
        Mockito.when(paymentModeRepository.saveAll(listModel)).thenReturn(listModel);

        List<PaymentModeDto> listDto = paymentModeService.savePaymentModes(
                PaymentModeUtilities.convertListModelToListDto(listModel));

        Assert.assertEquals("The data size does not match with expected data size",
                listModel.size(), listDto.size());
        Assert.assertEquals("Not valid Id ", listModel.get(listModel.size() - 1).getId(),
                listDto.get(listDto.size() - 1).getId());
        Assert.assertEquals("Not valid Name ", listModel.get(listModel.size() - 1).getName(),
                listDto.get(listDto.size() - 1).getName());
        Assert.assertEquals("Not valid Description ", listModel.get(listModel.size() - 1).getDescription(),
                listDto.get(listDto.size() - 1).getDescription());
    }

    @Test
    public void testWhenDeletePaymentModeExceptionIsThrown() throws NotFoundException {
        exceptionRule.expect(NotFoundException.class);
        exceptionRule.expectMessage("The Payment Mode was not found!");
        Mockito.when(paymentModeRepository.existsById(listModel.get(1).getId())).thenReturn(false);
        paymentModeService.deletePaymentMode(listModel.get(1).getId());
    }

    @Test
    public void testDeletePaymentMode() throws NotFoundException {
        Mockito.when(paymentModeRepository.existsById(listModel.get(1).getId())).thenReturn(true);
        paymentModeService.deletePaymentMode(listModel.get(1).getId());

        verify(paymentModeRepository, times(1)).deleteById(listModel.get(1).getId());
    }
}