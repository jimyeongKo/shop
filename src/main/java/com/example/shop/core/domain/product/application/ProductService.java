package com.example.shop.core.domain.product.application;

import com.example.shop.core.domain.image.domain.Image;
import com.example.shop.core.domain.product.domain.Product;
import com.example.shop.core.domain.product.dto.ProductRequest;
import com.example.shop.core.domain.product.dto.ProductResponse;
import com.example.shop.core.domain.product.persistence.ProductRepository;
import com.example.shop.core.global.error.FileSaveException;
import com.example.shop.core.global.file.FileUpload;
import com.example.shop.core.global.response.PagingResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class ProductService {

    private final ProductRepository repository;

    public ProductResponse create(ProductRequest request, List<MultipartFile> images) {

        Product product = Product.createProduct(request);

        images.forEach(image -> {
            final String IMAGE_LOCATION = "/post/image" + product.getId() + "/" + image.getOriginalFilename();

            try {
                FileUpload.uploadImage(image, IMAGE_LOCATION);

                Image productImage = Image.create(IMAGE_LOCATION, product);

                product.addImage(productImage);
            } catch (Exception e) {
                throw new FileSaveException(image.getOriginalFilename());
            }
        });

        repository.save(product);

        return new ProductResponse(product);
    }

    public PagingResponse<ProductResponse> getProduct(int page) {

        Page<Product> products = repository.findAll(paging(page));

        List<ProductResponse> data = products.getContent().stream().map(ProductResponse::new).collect(Collectors.toList());

        return new PagingResponse<>(page, products.getTotalPages(), products.getTotalElements(), data);
    }

    public Pageable paging(int page) {
        return PageRequest.of(page, 10, Sort.Direction.DESC, "id");
    }
}
