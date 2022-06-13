package com.example.shop.core.domain.product.api;

import com.example.shop.core.domain.product.application.ProductService;
import com.example.shop.core.domain.product.dto.ProductRequest;
import com.example.shop.core.domain.product.dto.ProductResponse;
import com.example.shop.core.global.response.ApiPagingResponse;
import com.example.shop.core.global.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("product")
public class ProductController {

    private final ProductService service;

    @PostMapping("/reg")
    public ApiResponse<String> createProduct(@RequestBody ProductRequest request) {
        return new ApiResponse(HttpStatus.CREATED, service.create(request));
    }

    @GetMapping()
    public ApiPagingResponse<ProductResponse> getList(@RequestParam int page) {
         return new ApiPagingResponse<>(HttpStatus.OK, service.getProduct(page));
    }
}
