package com.endava.store.storepets.service;

import com.endava.store.storepets.constants.Constants;
import com.endava.store.storepets.dto.ProductDto;
import com.endava.store.storepets.model.ProductModel;
import com.endava.store.storepets.repository.ProductRepository;
import com.endava.store.storepets.utilities.ProductUtilities;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService extends GenericService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductDto> getProducts() {
        List<ProductModel> listModel = productRepository.findAll();
        return ProductUtilities.convertListModelToListDto(listModel);
    }

    public ProductDto getProduct(UUID id) {
        ProductModel model = productRepository.getById(id);
        return ProductUtilities.convertModelToProductsDto(model);
    }

    public List<ProductDto> saveProducts(List<ProductDto> listDto){
        List<ProductModel> listModel = productRepository.saveAll(ProductUtilities.convertListDtoToListModel(listDto));
        return ProductUtilities.convertListModelToListDto(listModel);
    }


    public ProductDto updateProducts(ProductDto dto) throws NotFoundException {
        exist(productRepository,dto.getId(),Constants.PRODUCT);
        ProductModel model = ProductUtilities.convertDtoToProductsModel(dto);
        return ProductUtilities.convertModelToProductsDto(productRepository.save(model));
    }

    public void deleteProduct(UUID id) throws NotFoundException {
        delete(productRepository,id,Constants.PRODUCT);
    }
}
