package com.fis.sprint4.repository;

import com.fis.sprint4.model.Detective;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetectiveRepository extends JpaRepository<Detective, Long> {
    Detective findDetectiveByPersonUsername(String username);
}
