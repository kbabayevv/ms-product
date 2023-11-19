package az.ingress.msproduct.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import lombok.experimental.FieldNameConstants;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "products")
@ToString
@FieldNameConstants
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    Double price;
    Integer count;

    @OneToOne(mappedBy = "product",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    Manufacturer manufacturer;

    @ManyToMany(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    @JoinTable(
            name = "products_category",
            joinColumns = @JoinColumn(name = "products_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id")
    )
    Set<Category> categories = new HashSet<>();

}
