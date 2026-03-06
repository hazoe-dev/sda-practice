package dev.hazoe.exercise.spring.service;

import dev.hazoe.exercise.spring.entity.Product;
import dev.hazoe.exercise.spring.mapper.ProductMapper;
import dev.hazoe.exercise.spring.exception.ResourceNotFoundException;
import dev.hazoe.exercise.spring.dto.ProductRequest;
import dev.hazoe.exercise.spring.dto.ProductResponse;
import dev.hazoe.exercise.spring.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper mapper;

    public List<ProductResponse> getALl() {
        return productRepository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    public ProductResponse getById(Long id) {
        Product product = findById(id);
        return mapper.toResponse(product);
    }

    @Transactional
    public ProductResponse create(ProductRequest request) {
        validate(request);
        Product product = mapper.toEntity(request);
        Product savedProduct = productRepository.save(product);
        return mapper.toResponse(savedProduct);
    }

    private void validate(ProductRequest request) {
        if (request.price() <= 0) {
            throw new IllegalArgumentException("Price must be greater than zero");
        }

        if (request.stock() < 0) {
            throw new IllegalArgumentException("Stock must >= 0");
        }
    }

    @Transactional
    public ProductResponse update(Long id, ProductRequest request) {
        Product existing = findById(id);

        validate(request);

        existing.setName(request.name());
        existing.setPrice(request.price());
        existing.setStock(request.stock());

        Product updatedProduct = productRepository.save(existing);

        return mapper.toResponse(updatedProduct);
    }

    private Product findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found product by id: " + id));
    }

    @Transactional
    public void delete(Long id) {
        Product existing = findById(id);
        productRepository.delete(existing);
    }

    public List<Product> findByName(String name) {
        return productRepository.findByNameContainingIgnoreCase(name);
    }
}
