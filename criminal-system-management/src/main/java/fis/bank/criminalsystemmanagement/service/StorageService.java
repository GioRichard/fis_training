package fis.bank.criminalsystemmanagement.service;



import fis.bank.model.Storage;

import java.util.List;
import java.util.Optional;

public interface StorageService {
    Storage CreateStorage(Storage storage);
    Storage updateStorage(Storage storage);
    Storage deleteStorageById(Long id);
    List<Storage> fillAll();
    Optional<Storage> findById(Long id);
}
