package az.ingress.msproduct.controller;

import az.ingress.msproduct.dto.CategoryRequest;
import az.ingress.msproduct.dto.CategoryResponse;
import az.ingress.msproduct.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryResponse> save(@RequestBody CategoryRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.create(request));
    }

    @PostMapping("/{productId}/{categoryId}")
    public ResponseEntity<Void> add(@PathVariable Long productId, @PathVariable Long categoryId) {
        categoryService.add(productId, categoryId);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
