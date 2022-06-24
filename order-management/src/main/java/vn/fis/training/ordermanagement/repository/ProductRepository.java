package vn.fis.training.ordermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vn.fis.training.ordermanagement.dto.ProductDTO;

import java.util.List;

public interface ProductRepository  extends JpaRepository {
    @Query("select p from Product p")
    List<ProductDTO> findAllNameOnly();
}
