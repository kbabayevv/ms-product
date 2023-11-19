package az.ingress.msproduct.service;

import az.ingress.msproduct.dto.CategoryRequest;
import az.ingress.msproduct.dto.CategoryResponse;
import az.ingress.msproduct.entity.Category;
import az.ingress.msproduct.entity.Product;
import az.ingress.msproduct.repository.CategoryRepository;
import az.ingress.msproduct.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final ModelMapper mapper;

    public void add(Long productId, Long categoryId) {
        Product product = productRepository.findCategoriesProductById(productId)
                .orElseThrow(() -> new RuntimeException(String.format("Product with %s id not found", productId)));
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException(String.format("Category with %s id not found", categoryId)));
        product.getCategories().add(category);
        productRepository.save(product);
    }

    public CategoryResponse create(CategoryRequest request) {
        Category category = mapper.map(request, Category.class);
        List<Category> all = categoryRepository.findAll();
        for (Category value : all) {
            if (request.getName().equals(value.getName())) {
                throw new RuntimeException("Already exist region");
            }
        }
        Category saved = categoryRepository.save(category);
        return mapper.map(saved, CategoryResponse.class);
    }

}
