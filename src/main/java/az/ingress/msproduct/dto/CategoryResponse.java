package az.ingress.msproduct.dto;

import az.ingress.msproduct.entity.Category;
import az.ingress.msproduct.entity.Product;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@ToString
public class CategoryResponse {
    Long id;
    String name;

}
