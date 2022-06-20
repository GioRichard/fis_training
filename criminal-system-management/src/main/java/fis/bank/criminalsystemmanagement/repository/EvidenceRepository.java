package fis.bank.criminalsystemmanagement.repository;

import fis.bank.model.Evidence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvidenceRepository extends JpaRepository<Evidence,Long> {

}
