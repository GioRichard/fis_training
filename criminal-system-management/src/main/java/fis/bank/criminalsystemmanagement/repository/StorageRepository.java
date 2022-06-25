package fis.bank.criminalsystemmanagement.repository;

import fis.bank.criminalsystemmanagement.model.Detective;
import fis.bank.criminalsystemmanagement.model.Storage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;


@Repository
public interface StorageRepository extends AbstractRepoRepository<Storage> {
    Optional<Storage> findByName(String name);

    Set<Storage> findByLocation(String location);
}
