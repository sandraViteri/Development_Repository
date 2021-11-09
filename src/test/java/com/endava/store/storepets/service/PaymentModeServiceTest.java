package com.endava.store.storepets.service;

import com.endava.store.storepets.dto.PaymentModeDto;
import com.endava.store.storepets.model.PaymentModeModel;
import com.endava.store.storepets.repository.PaymentModeRepository;
import com.endava.store.storepets.testUtilities.UtilityPaymentModeData;
import com.endava.store.storepets.util.PaymentModeUtilities;
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
    private PaymentModeService PaymentModeService;
    @Mock
    private PaymentModeRepository PaymentModeRepository;

    List<PaymentModeModel> listModel;

    @Before
    public void setUp(){
        listModel = UtilityPaymentModeData.getPaymentModesModel();
    }

    @Test
    public void testDtoEqualToModelWhenGetPaymentModeById() {
        Mockito.when(PaymentModeRepository.getById(listModel.get(1).getId())).thenReturn(listModel.get(1));

        PaymentModeDto dto = PaymentModeService.getPaymentMode(listModel.get(1).getId());

        Assert.assertEquals("Not valid Id ", listModel.get(1).getId(), dto.getId());
        Assert.assertEquals("Not valid Name ", listModel.get(1).getName(), dto.getName());
        Assert.assertEquals("Not valid Description ", listModel.get(1).getDescription(), dto.getDescription());
    }

    @Test
    public void testDtoListEqualToModelListWhenGetAllPaymentModes() {
        Mockito.when(PaymentModeRepository.findAll()).thenReturn(listModel);

        List<PaymentModeDto> listDtoResult = PaymentModeService.getPaymentModes();

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
        Mockito.when(PaymentModeRepository.existsById(listModel.get(1).getId())).thenReturn(true);
        Mockito.when(PaymentModeRepository.save(listModel.get(1))).thenReturn(listModel.get(1));

        PaymentModeDto dto = PaymentModeService.updatePaymentMode(new PaymentModeDto(listModel.get(1).getId(),
                listModel.get(1).getName(), listModel.get(1).getDescription()));

        Assert.assertEquals("Not valid Id ", listModel.get(1).getId(), dto.getId());
        Assert.assertEquals("Not valid Name ", listModel.get(1).getName(), dto.getName());
        Assert.assertEquals("Not valid Description ", listModel.get(1).getDescription(), dto.getDescription());
    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();
    @Test
    public void testWhenPaymentModeDoesNotExistExceptionIsThrown() throws NotFoundException {
        exceptionRule.expect(NotFoundException.class);
        exceptionRule.expectMessage("The PaymentMode was not found!");
        Mockito.when(PaymentModeRepository.existsById(listModel.get(1).getId())).thenReturn(false);
        PaymentModeService.existPaymentMode(listModel.get(1).getId());
    }

    @Test
    public void testModelAndDtoFunctionalityUsingSavePaymentModes() {
        Mockito.when(PaymentModeRepository.saveAll(listModel)).thenReturn(listModel);

        List<PaymentModeDto> listDto = PaymentModeService.savePaymentModes(
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
        exceptionRule.expectMessage("The PaymentMode was not found!");
        Mockito.when(PaymentModeRepository.existsById(listModel.get(1).getId())).thenReturn(false);
        PaymentModeService.deletePaymentMode(listModel.get(1).getId());
    }

    @Test
    public void testDeletePaymentMode() throws NotFoundException {
        Mockito.when(PaymentModeRepository.existsById(listModel.get(1).getId())).thenReturn(true);
        PaymentModeService.deletePaymentMode(listModel.get(1).getId());

        verify(PaymentModeRepository, times(1)).deleteById(listModel.get(1).getId());
    }
}