package com.endava.store.storepets.service;

import com.endava.store.storepets.dto.InvoiceDto;
import com.endava.store.storepets.model.InvoiceModel;
import com.endava.store.storepets.repository.InvoiceRepository;
import com.endava.store.storepets.testdata.InvoiceData;
import com.endava.store.storepets.utilities.InvoiceUtilities;
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
public class InvoiceServiceTest {

    @InjectMocks
    private InvoiceService invoiceService;
    @Mock
    private InvoiceRepository invoiceRepository;

    private List<InvoiceModel> listModel;

    @Before
    public void setUp(){
        listModel = InvoiceData.getInvoicesModel();
    }

    @Test
    public void testDtoEqualToModelWhenGetInvoiceById() {
        Mockito.when(invoiceRepository.getById(listModel.get(1).getId())).thenReturn(listModel.get(1));

        InvoiceDto dto = invoiceService.getInvoice(listModel.get(1).getId());

        Assert.assertEquals("Not valid Id ", listModel.get(1).getId(), dto.getId());
        Assert.assertEquals("Not valid User", listModel.get(1).getUser(), dto.getUser());
        Assert.assertEquals("Not valid Payment Mode ", listModel.get(1).getPaymentMode(), dto.getPaymentMode());
        Assert.assertEquals("Not valid Date ", listModel.get(1).getDate(), dto.getDate());
        Assert.assertEquals("Not valid Total Value ", listModel.get(1).getTotalValue(), dto.getTotalValue());
        Assert.assertEquals("Not valid Taxes ", listModel.get(1).getTaxes(), dto.getTaxes());
        Assert.assertEquals("Not valid Discount ", listModel.get(1).getDiscount(), dto.getDiscount());
    }

    @Test
    public void testDtoEqualToModelWhenGetInvoices() {
        Mockito.when(invoiceRepository.findAll()).thenReturn(listModel);

        List<InvoiceDto> listDto = invoiceService.getInvoices();

        Assert.assertEquals("The data size does not match with expected data size",
                listModel.size(), listDto.size());
        Assert.assertEquals("Not valid Id ", listModel.get(listModel.size() - 1).getId(),
                listDto.get(listDto.size() - 1).getId());
        Assert.assertEquals("Not valid Payment Mode", listModel.get(listModel.size() - 1).getPaymentMode(),
                listDto.get(listDto.size() - 1).getPaymentMode());
        Assert.assertEquals("Not valid Date ", listModel.get(listModel.size() - 1).getDate(),
                listDto.get(listDto.size() - 1).getDate());
        Assert.assertEquals("Not valid User ", listModel.get(listModel.size() - 1).getUser(),
                listDto.get(listDto.size() - 1).getUser());
        Assert.assertEquals("Not valid Discount ", listModel.get(listModel.size() - 1).getDiscount(),
                listDto.get(listDto.size() - 1).getDiscount());
        Assert.assertEquals("Not valid Total Value ", listModel.get(listModel.size() - 1).getTotalValue(),
                listDto.get(listDto.size() - 1).getTotalValue());
        Assert.assertEquals("Not valid Taxes ", listModel.get(listModel.size() - 1).getTaxes(),
                listDto.get(listDto.size() - 1).getTaxes());
    }

    @Test
    public void testDtoListEqualToModelListWhenUpdateInvoices() throws NotFoundException {
        Mockito.when(invoiceRepository.existsById(listModel.get(1).getId())).thenReturn(true);
        Mockito.when(invoiceRepository.save(listModel.get(1))).thenReturn(listModel.get(1));

        InvoiceDto dto = invoiceService.updateInvoices(new InvoiceDto(listModel.get(1).getId(),
                listModel.get(1).getUser(),
                listModel.get(1).getPaymentMode(),
                listModel.get(1).getDate(),
                listModel.get(1).getTotalValue(),
                listModel.get(1).getTaxes(),
                listModel.get(1).getDiscount()));

        Assert.assertEquals("Not valid Id ", listModel.get(1).getId(), dto.getId());
        Assert.assertEquals("Not valid User", listModel.get(1).getUser(), dto.getUser());
        Assert.assertEquals("Not valid Payment Mode ", listModel.get(1).getPaymentMode(), dto.getPaymentMode());
        Assert.assertEquals("Not valid Date ", listModel.get(1).getDate(), dto.getDate());
        Assert.assertEquals("Not valid Total Value ", listModel.get(1).getTotalValue(), dto.getTotalValue());
        Assert.assertEquals("Not valid Taxes ", listModel.get(1).getTaxes(), dto.getTaxes());
        Assert.assertEquals("Not valid Discount ", listModel.get(1).getDiscount(), dto.getDiscount());
    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();
    @Test
    public void testModelAndDtoFunctionalityWhenSaveInvoices(){
        Mockito.when(invoiceRepository.saveAll(listModel)).thenReturn(listModel);

        List<InvoiceDto> listDto = invoiceService.saveInvoices(InvoiceUtilities.convertListModelToListDto(listModel));

        Assert.assertEquals("The data size does not match with expected data size",
                listModel.size(), listDto.size());
        Assert.assertEquals("Not valid Id ", listModel.get(listModel.size() - 1).getId(),
                listDto.get(listDto.size() - 1).getId());
        Assert.assertEquals("Not valid Payment Mode", listModel.get(listModel.size() - 1).getPaymentMode(),
                listDto.get(listDto.size() - 1).getPaymentMode());
        Assert.assertEquals("Not valid Date ", listModel.get(listModel.size() - 1).getDate(),
                listDto.get(listDto.size() - 1).getDate());
        Assert.assertEquals("Not valid User ", listModel.get(listModel.size() - 1).getUser(),
                listDto.get(listDto.size() - 1).getUser());
        Assert.assertEquals("Not valid Discount ", listModel.get(listModel.size() - 1).getDiscount(),
                listDto.get(listDto.size() - 1).getDiscount());
        Assert.assertEquals("Not valid Total Value ", listModel.get(listModel.size() - 1).getTotalValue(),
                listDto.get(listDto.size() - 1).getTotalValue());
        Assert.assertEquals("Not valid Taxes ", listModel.get(listModel.size() - 1).getTaxes(),
                listDto.get(listDto.size() - 1).getTaxes());
    }

    @Test
    public void testDeleteInvoice() throws NotFoundException {
        Mockito.when(invoiceRepository.existsById(listModel.get(1).getId())).thenReturn(true);
        invoiceService.deleteInvoice(listModel.get(1).getId());

        verify(invoiceRepository, times(1)).deleteById(listModel.get(1).getId());
    }

    @Test
    public void testWhenDeleteInvoiceTypeExceptionIsThrown() throws NotFoundException {
        exceptionRule.expect(NotFoundException.class);
        exceptionRule.expectMessage("The Invoice was not found!");
        Mockito.when(invoiceRepository.existsById(listModel.get(1).getId())).thenReturn(false);
        invoiceService.deleteInvoice(listModel.get(1).getId());
    }
}