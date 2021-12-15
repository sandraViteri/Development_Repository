package com.endava.store.storepets.model;

import com.endava.store.storepets.dto.ProductDto;
import lombok.*;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(schema = "public", name = "\"products\"")
public class ProductModel extends GenericModel {

    @Builder
    public ProductModel(ProductDto productDto) {
        super(productDto.getId(), productDto.getName(), productDto.getDescription());
        this.color=productDto.getColor();
        this.size=productDto.getSize();
        this.value=productDto.getValue();
        this.category=productDto.getCategory();
        this.stock=productDto.getStock();
    }

    @Basic(optional = false)
    @Column(name = "\"color\"")
    private String color;
    @Basic(optional = false)
    @Column(name = "\"size\"")
    private String size;
    @Basic(optional = false)
    @Column(name = "\"value\"")
    private Double value;
    @Column(name = "\"category\"")
    private UUID category;
    @Column(name = "\"stock\"")
    private Integer stock;

    @Override
    public String toString() {
        return "com.endava.store.storepets.model.ProductModel[id=" + super.getId() + "]";
    }
}
