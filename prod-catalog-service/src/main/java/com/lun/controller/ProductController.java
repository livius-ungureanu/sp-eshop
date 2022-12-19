package com.lun.controller;

import com.lun.dto.ProductRequest;
import com.lun.dto.ProductResponse;
import com.lun.exceptions.ProductNotFoundException;
import com.lun.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/catalog/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<HttpStatus> createProduct(@RequestBody ProductRequest productRequest) {
        productService.createProduct(productRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProductResponse>> getProducts() {
        return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProduct(@PathVariable String id) {
        return productService.getProduct(id)
              .map(product -> new ResponseEntity<>(product, HttpStatus.OK))
              .orElseThrow(() -> new ProductNotFoundException(id));
    }

    @GetMapping("/sku/{sku}")
    public ResponseEntity<ProductResponse> getProductBySku(@PathVariable String sku) {
        return productService.getProductBySku(sku)
              .map(product -> new ResponseEntity<>(product, HttpStatus.OK))
              .orElseThrow(() -> new ProductNotFoundException(sku));

    }
}
