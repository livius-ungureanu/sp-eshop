package com.lun.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.lun.model.Product;


public interface ProductRepo extends MongoRepository<Product, String> {

}
