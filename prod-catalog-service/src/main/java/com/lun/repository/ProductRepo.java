package repository;

import com.lun.catalog.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ProductRepo extends MongoRepository<Product, String> {

}
