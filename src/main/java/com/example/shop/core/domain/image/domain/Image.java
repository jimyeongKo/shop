package com.example.shop.core.domain.image.domain;

import com.example.shop.core.domain.product.domain.Product;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String path;

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    public static Image create(String path, Product product) {
        return Image.builder()
                .path(path)
                .product(product)
                .build();
    }
}
