package ru.geekbrains.common;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class ProductDto implements Serializable {

    private static final long serialVersionUID = 8517640058574946951L;
    private  Long id;

    @Size(min = 4, max = 255, message="Title size: 4-255")
    private String title;

    private String categoryTitle;

    @Min(value = 1, message ="Min price = 1")
    private BigDecimal price;

    public ProductDto(Long id, String title, BigDecimal price, String categoryTitle){
        this.id=id;
        this.title=title;
        this.categoryTitle=categoryTitle;
        this.price=price;
    }
}
