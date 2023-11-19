package az.ingress.msproduct.repository;

import az.ingress.msproduct.entity.Product;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {

    @Query(value = "select p from Product p where p.id= :id")
    Optional<Product> findById(Long id);


    @Query(value = "select p from Product p join fetch p.categories c join  fetch  p.manufacturer m")
    List<Product> findAll();

    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH, attributePaths = "categories")
    Optional<Product> findCategoriesProductById(Long id);

    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH, attributePaths = "categories")
    List<Product> findAllByCategoriesId(Long categoryId);

    @Query(value = "select p from Product p join fetch p.categories c join  fetch  p.manufacturer m")
    List<Product> findAll(Specification<Product> specification);
}
