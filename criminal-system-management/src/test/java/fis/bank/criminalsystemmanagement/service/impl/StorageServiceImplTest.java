package fis.bank.criminalsystemmanagement.service.impl;

import fis.bank.criminalsystemmanagement.model.Detective;
import fis.bank.criminalsystemmanagement.model.Storage;
import fis.bank.criminalsystemmanagement.service.StorageService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class StorageServiceImplTest {
    @Autowired
    private StorageService storageService;
    @Test
    void createStorage() {

    }

    @Test
    void updateStorage() {
    }

    @Test
    void deleteStorageById() {
        storageService.deleteStorageById(3L);
    }

    @Test
    void fillAll() {
        storageService.fillAll();
    }

    @Test
    void findById() {
        storageService.findById(1L);
    }
}