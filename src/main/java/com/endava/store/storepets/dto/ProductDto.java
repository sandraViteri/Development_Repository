package com.endava.store.storepets.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDto implements Serializable {

    private UUID id;

    @NotEmpty(message = "{validation.productDto.name.empty}")
    @Size(min = 1, max = 255, message = "{validation.productDto.name.size}")
    private String name;

    @Size(min = 5, max = 300, message = "{validation.productDto.description.empty}")
    private String description;

    @NotEmpty(message = "{validation.productDto.color.empty}")
    private String color;

    @NotEmpty(message = "{validation.productDto.size.empty}")
    private String size;

    @NotNull(message = "{validation.productDto.value.empty}")
    @Min(value = 1, message = "{validation.productDto.value.noZero}")
    private Double value;


    @NotNull(message = "{validation.productDto.stock.empty}")
    private Integer stock;

    @NotNull(message = "{validation.productDto.category.empty}")
    private UUID category;

}