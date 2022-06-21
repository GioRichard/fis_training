package fis.bank.criminalsystemmanagement.service.impl;

import fis.bank.criminalsystemmanagement.service.DetectiveService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DetectiveServiceImplTest {

    @Autowired
    private DetectiveService detectiveService;
    @Test
    void createDetective() {
    }

    @Test
    void updateDetective() {
    }

    @Test
    void fillAll() {
        detectiveService.fillAll();
    }

    @Test
    void findById() {
        detectiveService.findById(1L);
    }

    @Test
    void deleteDetectiveById() {
        detectiveService.deleteDetectiveById(1l);
    }
}