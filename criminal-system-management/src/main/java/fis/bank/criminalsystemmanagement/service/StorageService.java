package fis.bank.criminalsystemmanagement.service;



import fis.bank.criminalsystemmanagement.model.Storage;

import java.util.Set;

public interface StorageService {
    void create(Storage storage);
    Set<Storage> getALl();
    Storage findById(Long id);
    Storage update(Storage storage);
    void deleteById(Long id);
}
