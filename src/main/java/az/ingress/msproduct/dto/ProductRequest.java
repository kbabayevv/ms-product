package az.ingress.msproduct.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@ToString
public class ProductRequest {
    String name;
    Integer count;
    Double price;
}
