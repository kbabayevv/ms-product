package az.ingress.msproduct.controller;

import az.ingress.msproduct.dto.ProductRequest;
import az.ingress.msproduct.dto.ProductResponse;
import az.ingress.msproduct.dto.ProductResponseWithCategory;
import az.ingress.msproduct.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody ProductRequest request) {
        productService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProductResponse>> getAll() {
        return ResponseEntity.ok(productService.getAll());
    }

    @GetMapping("/{price}")
    public ResponseEntity<List<ProductResponse>> getAll(@PathVariable Double price) {
        return ResponseEntity.ok(productService.getAllByCategoryId(price));
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<ProductResponseWithCategory>> getAll(@PathVariable Long categoryId) {
        return ResponseEntity.ok(productService.findAllByCategoriesId(categoryId));
    }
}
