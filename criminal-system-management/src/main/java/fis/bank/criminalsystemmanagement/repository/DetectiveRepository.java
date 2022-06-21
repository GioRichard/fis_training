package fis.bank.criminalsystemmanagement.repository;

import fis.bank.criminalsystemmanagement.model.Detective;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetectiveRepository extends JpaRepository<Detective, Long> {

}
