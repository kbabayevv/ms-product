package az.ingress.msproduct.dto;

import az.ingress.msproduct.entity.Manufacturer;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ManufacturerResponse {
    Long id;
    String name;
    String aboutUs;

    public ManufacturerResponse(Manufacturer manufacturer) {
        this.id = manufacturer.getId();
        this.name = manufacturer.getName();
        this.aboutUs = manufacturer.getAboutUs();
    }
}
