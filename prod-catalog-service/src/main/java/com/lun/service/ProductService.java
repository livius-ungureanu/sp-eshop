package com.lun.service;

import com.lun.dto.ProductRequest;
import com.lun.dto.ProductResponse;
import com.lun.model.Product;
import com.lun.repository.ProductRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor // Generates a constructor with 1 parameter for each final field
@Slf4j
public class ProductService {

    private final ProductRepo productRepo;

    public void createProduct(ProductRequest productRequest) {
        // dto -> model
        Product product = Product.builder()
                .name(productRequest.getName())
                .sku(productRequest.getSku())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();
        
        // Save product to database
        productRepo.save(product);

        log.info("Product created: {}", product);
    }

    public List<ProductResponse> getProducts() {
        // Get all products from database
        List<Product> products = productRepo.findAll();

        // model -> dto
        List<ProductResponse> result  = products.stream()
            .map(product -> mapToProductResponse(product))
            .toList();

        return result;    
    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .sku(product.getSku())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }

    public Optional<ProductResponse> getProduct(String id) {
       return productRepo.findById(id)
            .map(prodcut -> mapToProductResponse(prodcut));
    }

    public Optional<ProductResponse> getProductBySku(String sku) {
        return getProducts().stream()
            .filter(product -> product.getSku().equals(sku))
            .findFirst();
    }
}
