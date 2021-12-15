package com.endava.store.storepets.service;

import com.endava.store.storepets.dto.ProductDto;
import com.endava.store.storepets.model.ProductModel;
import com.endava.store.storepets.repository.ProductRepository;
import com.endava.store.storepets.testdata.ProductData;
import com.endava.store.storepets.utilities.ProductUtilities;
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
public class ProductServiceTest {

    @InjectMocks
    private ProductService ProductService;
    @Mock
    private ProductRepository ProductRepository;

    private List<ProductModel> listModel;

    @Before
    public void setUp(){
        listModel = ProductData.getProductsModel();
    }

    @Test
    public void testDtoEqualToModelWhenGetProductById() {
        Mockito.when(ProductRepository.getById(listModel.get(1).getId())).thenReturn(listModel.get(1));

        ProductDto dto = ProductService.getProduct(listModel.get(1).getId());

        Assert.assertEquals("Not valid Id ", listModel.get(1).getId(), dto.getId());
        Assert.assertEquals("Not valid Id Name", listModel.get(1).getName(), dto.getName());
        Assert.assertEquals("Not valid Description ", listModel.get(1).getDescription(), dto.getDescription());
        Assert.assertEquals("Not valid Color ", listModel.get(1).getColor(), dto.getColor());
        Assert.assertEquals("Not valid Size ", listModel.get(1).getSize(), dto.getSize());
        Assert.assertEquals("Not valid Value", listModel.get(1).getValue(),dto.getValue());
        Assert.assertEquals("Not valid Stock ", listModel.get(1).getStock(),dto.getStock());
        Assert.assertEquals("Not valid Category ", listModel.get(1).getCategory(), dto.getCategory());
    }

    @Test
    public void testDtoEqualToModelWhenGetProducts() {
        Mockito.when(ProductRepository.findAll()).thenReturn(listModel);

        List<ProductDto> listDto = ProductService.getProducts();

        Assert.assertEquals("The data size does not match with expected data size",
                listModel.size(), listDto.size());
        Assert.assertEquals("Not valid Id ", listModel.get(listModel.size() - 1).getId(),
                listDto.get(listDto.size() - 1).getId());
        Assert.assertEquals("Not valid Name ", listModel.get(listModel.size() - 1).getName(),
                listDto.get(listDto.size() - 1).getName());
        Assert.assertEquals("Not valid Last Description ", listModel.get(listModel.size() - 1).getDescription(),
                listDto.get(listDto.size() - 1).getDescription());
        Assert.assertEquals("Not valid Color ", listModel.get(listModel.size() - 1).getColor(),
               listDto.get(listDto.size() - 1).getColor());
        Assert.assertEquals("Not valid Size ", listModel.get(listModel.size() - 1).getSize(),
                listDto.get(listDto.size() - 1).getSize());
        Assert.assertEquals("Not valid Stock ", listModel.get(listModel.size() - 1).getStock(),
                listDto.get(listDto.size() - 1).getStock());
        Assert.assertEquals("Not valid Value ", listModel.get(listModel.size() - 1).getValue()
                ,listDto.get(listDto.size() - 1).getValue());
        Assert.assertEquals("Not valid Category ", listModel.get(listModel.size() - 1).getCategory(),
                listDto.get(listDto.size() - 1).getCategory());
    }
    @Test
    public void testDtoListEqualToModelListWhenUpdateProducts() throws NotFoundException {
        Mockito.when(ProductRepository.existsById(listModel.get(1).getId())).thenReturn(true);
        Mockito.when(ProductRepository.save(listModel.get(1))).thenReturn(listModel.get(1));

        ProductDto dto = ProductService.updateProducts(new ProductDto(listModel.get(1).getId(),
                listModel.get(1).getName(),
                listModel.get(1).getDescription(),
                listModel.get(1).getColor(),
                listModel.get(1).getSize(),
                listModel.get(1).getValue(),
                listModel.get(1).getStock(),
                listModel.get(1).getCategory()));

        Assert.assertEquals("Not valid Id ", listModel.get(1).getId(), dto.getId());
        Assert.assertEquals("Not valid Id Name", listModel.get(1).getName(), dto.getName());
        Assert.assertEquals("Not valid Description ", listModel.get(1).getDescription(), dto.getDescription());
        Assert.assertEquals("Not valid Color ", listModel.get(1).getColor(), dto.getColor());
        Assert.assertEquals("Not valid Size ", listModel.get(1).getSize(), dto.getSize());
        Assert.assertEquals("Not valid Value", listModel.get(1).getValue(), dto.getValue());
        Assert.assertEquals("Not valid Stock ", listModel.get(1).getStock(), dto.getStock());
        Assert.assertEquals("Not valid Category ", listModel.get(1).getCategory(), dto.getCategory());
    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();
    @Test
    public void testModelAndDtoFunctionalityWhenSaveProducts(){
        Mockito.when(ProductRepository.saveAll(listModel)).thenReturn(listModel);

        List<ProductDto> listDto = ProductService.saveProducts(ProductUtilities.convertListModelToListDto(listModel));

        Assert.assertEquals("The data size does not match with expected data size",
                listModel.size(), listDto.size());
        Assert.assertEquals("Not valid Id ", listModel.get(listModel.size() - 1).getId(),
                listDto.get(listDto.size() - 1).getId());
        Assert.assertEquals("Not valid Name ", listModel.get(listModel.size() - 1).getName(),
                listDto.get(listDto.size() - 1).getName());
        Assert.assertEquals("Not valid Last Description ", listModel.get(listModel.size() - 1).getDescription(),
                listDto.get(listDto.size() - 1).getDescription());
        Assert.assertEquals("Not valid Color ", listModel.get(listModel.size() - 1).getColor(),
                listDto.get(listDto.size() - 1).getColor());
        Assert.assertEquals("Not valid Size ", listModel.get(listModel.size() - 1).getSize(),
                listDto.get(listDto.size() - 1).getSize());
        Assert.assertEquals("Not valid Stock ", listModel.get(listModel.size() - 1).getStock(),
                listDto.get(listDto.size() - 1).getStock());
        Assert.assertEquals("Not valid Value ", listModel.get(listModel.size() - 1)
                .getValue(),listDto.get(listDto.size() - 1).getValue());
        Assert.assertEquals("Not valid Category ", listModel.get(listModel.size() - 1).getCategory(),
                listDto.get(listDto.size() - 1).getCategory());
    }

    @Test
    public void testDeleteProduct() throws NotFoundException {
        Mockito.when(ProductRepository.existsById(listModel.get(1).getId())).thenReturn(true);
        ProductService.deleteProduct(listModel.get(1).getId());

        verify(ProductRepository, times(1)).deleteById(listModel.get(1).getId());
    }

    @Test
    public void testWhenDeleteProductTypeExceptionIsThrown() throws NotFoundException {
        exceptionRule.expect(NotFoundException.class);
        exceptionRule.expectMessage("Product was not found!");
        Mockito.when(ProductRepository.existsById(listModel.get(1).getId())).thenReturn(false);
        ProductService.deleteProduct(listModel.get(1).getId());
    }
}