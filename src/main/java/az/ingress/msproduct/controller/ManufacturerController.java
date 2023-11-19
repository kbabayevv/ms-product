package az.ingress.msproduct.controller;

import az.ingress.msproduct.dto.ManufacturerRequest;
import az.ingress.msproduct.dto.ManufacturerResponse;
import az.ingress.msproduct.service.ManufacturerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/manufacturer")
public class ManufacturerController {
    private final ManufacturerService manufacturerService;

    @PostMapping("/{productId}")
    public ResponseEntity<ManufacturerResponse> save(@PathVariable Long productId, @RequestBody ManufacturerRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(manufacturerService.save(productId, request));
    }

}
