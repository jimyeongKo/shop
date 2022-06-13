package com.example.shop.core.domain.product.dto;

import com.example.shop.core.domain.product.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {
    private Long id;
    private String name;

    private Integer price;

    //설명
    private String description;

    //옷 분류(enum으로 분류 예정)
    private String category;

    //조회수
    private Integer viewCount;

    //구매개수
    private Integer purchaseCount;

    private LocalDateTime regDate;

    public ProductResponse(final Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
        this.description = product.getDescription();
        this.category = product.getCategory();
        this.viewCount = product.getViewCount();
        this.purchaseCount = product.getPurchaseCount();
        this.regDate = product.getRegDate();
    }
}
