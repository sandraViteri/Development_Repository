package com.endava.store.storepets.service;

import com.endava.store.storepets.dto.DetailDto;
import com.endava.store.storepets.model.DetailModel;
import com.endava.store.storepets.repository.DetailRepository;
import com.endava.store.storepets.testdata.DetailData;
import com.endava.store.storepets.utilities.DetailUtilities;
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
public class DetailServiceTest {

    @InjectMocks
    private DetailService detailService;
    @Mock
    private DetailRepository detailRepository;

    private List<DetailModel> listModel;

    @Before
    public void setUp(){
        listModel = DetailData.getDetailsModel();
    }

    @Test
    public void testDtoEqualToModelWhenGetDetailById() {
        Mockito.when(detailRepository.getById(listModel.get(1).getId())).thenReturn(listModel.get(1));

        DetailDto dto = detailService.getDetail(listModel.get(1).getId());

        Assert.assertEquals("Not valid Id ", listModel.get(1).getId(), dto.getId());
        Assert.assertEquals("Not valid Invoice", listModel.get(1).getInvoice(), dto.getInvoice());
        Assert.assertEquals("Not valid Product ", listModel.get(1).getProduct(), dto.getProduct());
        Assert.assertEquals("Not valid Amount ", listModel.get(1).getAmount(), dto.getAmount());
        Assert.assertEquals("Not valid Value ", listModel.get(1).getValue(), dto.getValue());
    }

    @Test
    public void testDtoEqualToModelWhenGetDetails() {
        Mockito.when(detailRepository.findAll()).thenReturn(listModel);

        List<DetailDto> listDto = detailService.getDetails();

        Assert.assertEquals("The data size does not match with expected data size",
                listModel.size(), listDto.size());
        Assert.assertEquals("Not valid Id ", listModel.get(listModel.size() - 1).getId(),
                listDto.get(listDto.size() - 1).getId());
        Assert.assertEquals("Not valid Product", listModel.get(listModel.size() - 1).getProduct(),
                listDto.get(listDto.size() - 1).getProduct());
        Assert.assertEquals("Not valid Invoice ", listModel.get(listModel.size() - 1).getInvoice(),
                listDto.get(listDto.size() - 1).getInvoice());
        Assert.assertEquals("Not valid Value ", listModel.get(listModel.size() - 1).getValue(),
                listDto.get(listDto.size() - 1).getValue());
        Assert.assertEquals("Not valid Amount ", listModel.get(listModel.size() - 1).getAmount(),
                listDto.get(listDto.size() - 1).getAmount());
    }

    @Test
    public void testDtoListEqualToModelListWhenUpdateDetails() throws NotFoundException {
        Mockito.when(detailRepository.existsById(listModel.get(1).getId())).thenReturn(true);
        Mockito.when(detailRepository.save(listModel.get(1))).thenReturn(listModel.get(1));

        DetailDto dto = detailService.updateDetails(new DetailDto(listModel.get(1).getId(),
                listModel.get(1).getInvoice(),
                listModel.get(1).getProduct(),
                listModel.get(1).getAmount(),
                listModel.get(1).getValue()));

        Assert.assertEquals("Not valid Id ", listModel.get(1).getId(), dto.getId());
        Assert.assertEquals("Not valid Invoice", listModel.get(1).getInvoice(), dto.getInvoice());
        Assert.assertEquals("Not valid Product ", listModel.get(1).getProduct(), dto.getProduct());
        Assert.assertEquals("Not valid Amount ", listModel.get(1).getAmount(), dto.getAmount());
        Assert.assertEquals("Not valid Value ", listModel.get(1).getValue(), dto.getValue());
    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();
    @Test
    public void testModelAndDtoFunctionalityWhenSaveDetails(){
        Mockito.when(detailRepository.saveAll(listModel)).thenReturn(listModel);

        List<DetailDto> listDto = detailService.saveDetails(DetailUtilities.convertListModelToListDto(listModel));

        Assert.assertEquals("The data size does not match with expected data size",
                listModel.size(), listDto.size());
        Assert.assertEquals("Not valid Id ", listModel.get(listModel.size() - 1).getId(),
                listDto.get(listDto.size() - 1).getId());
        Assert.assertEquals("Not valid Product", listModel.get(listModel.size() - 1).getProduct(),
                listDto.get(listDto.size() - 1).getProduct());
        Assert.assertEquals("Not valid Invoice ", listModel.get(listModel.size() - 1).getInvoice(),
                listDto.get(listDto.size() - 1).getInvoice());
        Assert.assertEquals("Not valid Value ", listModel.get(listModel.size() - 1).getValue(),
                listDto.get(listDto.size() - 1).getValue());
        Assert.assertEquals("Not valid Amount ", listModel.get(listModel.size() - 1).getAmount(),
                listDto.get(listDto.size() - 1).getAmount());
    }

    @Test
    public void testDeleteDetail() throws NotFoundException {
        Mockito.when(detailRepository.existsById(listModel.get(1).getId())).thenReturn(true);
        detailService.deleteDetail(listModel.get(1).getId());

        verify(detailRepository, times(1)).deleteById(listModel.get(1).getId());
    }

    @Test
    public void testWhenDeleteDetailTypeExceptionIsThrown() throws NotFoundException {
        exceptionRule.expect(NotFoundException.class);
        exceptionRule.expectMessage("The Detail was not found!");
        Mockito.when(detailRepository.existsById(listModel.get(1).getId())).thenReturn(false);
        detailService.deleteDetail(listModel.get(1).getId());
    }
}