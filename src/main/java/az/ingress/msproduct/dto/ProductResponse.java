package az.ingress.msproduct.dto;

import az.ingress.msproduct.entity.Product;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductResponse {
    Long id;
    String name;
    Double price;
    Integer count;
    ManufacturerResponse manufacturerResponse;
    Set<CategoryResponse> categories = new HashSet<>();

    public ProductResponse(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
        this.count = product.getCount();
        this.manufacturerResponse = new ManufacturerResponse(product.getManufacturer());
        this.categories = new ModelMapper().map(product.getCategories(), Set.class);
    }

}
