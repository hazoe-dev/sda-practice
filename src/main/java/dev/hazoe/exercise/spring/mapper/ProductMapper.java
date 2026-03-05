package dev.hazoe.exercise.spring.mapper;

import dev.hazoe.exercise.spring.entity.Product;
import dev.hazoe.exercise.spring.dto.ProductRequest;
import dev.hazoe.exercise.spring.dto.ProductResponse;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public Product toEntity(ProductRequest request) {
        Product product = new Product();
        product.setName(request.name());
        product.setPrice(request.price());
        product.setStock(request.stock());
        return product;
    }

    public ProductResponse toResponse(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getStock()
        );
    }
}

