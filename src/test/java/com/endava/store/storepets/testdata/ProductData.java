package com.endava.store.storepets.testdata;

import com.endava.store.storepets.dto.ProductDto;
import com.endava.store.storepets.model.ProductModel;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ProductData {
    public static List<ProductModel> getProductsModel() {
        List<ProductModel> listModel = new ArrayList<>();
        ProductDto productDto=new ProductDto();
        productDto.setId(UUID.fromString("09df742e-33a3-11ec-8f02-6949411d6566"));
        productDto.setName("Product Service");
        productDto.setDescription("Test Service product one");
        productDto.setColor("Red");
        productDto.setSize("L");
        productDto.setValue(20000.00);
        productDto.setCategory(UUID.fromString("128c4a16-c04d-4b5c-86f9-5b323d6a9ab1"));
        productDto.setStock(20);
        listModel.add(new ProductModel(productDto));
        ProductDto productDtoDos=new ProductDto();
        productDtoDos.setId(UUID.fromString("09df742e-33a3-11ec-8f02-6949411d6577"));
        productDtoDos.setName("Product Service2");
        productDtoDos.setDescription("Test Service product two");
        productDtoDos.setColor("Blue");
        productDtoDos.setSize("M");
        productDtoDos.setValue(50000.00);
        productDtoDos.setCategory(UUID.fromString("34acd44d-db0a-46fd-8323-ffe869a9e7d2"));
        productDtoDos.setStock(30);
        listModel.add(new ProductModel(productDtoDos));
        return listModel;
    }
}
