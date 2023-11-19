package az.ingress.msproduct.service;

import az.ingress.msproduct.dto.ProductRequest;
import az.ingress.msproduct.dto.ProductResponse;
import az.ingress.msproduct.dto.ProductResponseWithCategory;
import az.ingress.msproduct.entity.Product;
import az.ingress.msproduct.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper mapper;

    public void save(ProductRequest request) {
        Product product = mapper.map(request, Product.class);
        productRepository.save(product);
    }

    public List<ProductResponse> getAll() {
        return productRepository.findAll().stream()
                .map(ProductResponse::new).collect(Collectors.toList());
    }

    public List<ProductResponseWithCategory> findAllByCategoriesId(Long categoryId) {
        return productRepository.findAllByCategoriesId(categoryId)
                .stream().map(ProductResponseWithCategory::new).collect(Collectors.toList());
    }

    public List<ProductResponse> getAllByCategoryId(Double price) {
        return productRepository.findAll(getPriceLessThan(price)).stream()
                .map(ProductResponse::new).collect(Collectors.toList());
    }

    private Specification<Product> getPriceLessThan(double price) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThan(root.get(Product.Fields.price), price);
    }
}
