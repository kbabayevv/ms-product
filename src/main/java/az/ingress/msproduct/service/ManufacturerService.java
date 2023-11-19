package az.ingress.msproduct.service;

import az.ingress.msproduct.dto.ManufacturerRequest;
import az.ingress.msproduct.dto.ManufacturerResponse;
import az.ingress.msproduct.entity.Manufacturer;
import az.ingress.msproduct.entity.Product;
import az.ingress.msproduct.repository.ManufacturerRepository;
import az.ingress.msproduct.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ManufacturerService {

    private final ManufacturerRepository manufacturerRepository;
    private final ProductRepository productRepository;
    private final ModelMapper mapper;

    public ManufacturerResponse save(Long productId, ManufacturerRequest request) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException(String.format("Product with %s id not found", productId)));
        Manufacturer manufacturer = mapper.map(request, Manufacturer.class);
        manufacturer.setProduct(product);
        product.setManufacturer(manufacturer);
        manufacturerRepository.save(manufacturer);
        productRepository.save(product);
        return mapper.map(manufacturer,ManufacturerResponse.class);
    }


}
