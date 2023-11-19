package az.ingress.msproduct.repository;

import az.ingress.msproduct.entity.Category;
import az.ingress.msproduct.entity.Product;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query(value = "select p from Category p where p.id= :id")
    Optional<Category> findById(Long id);

    @Query(value = "select p from Category p")
    List<Category> findAll();


}
