package com.fis.sprint4.service;

import com.fis.sprint4.model.Storage;

import java.util.Set;

public interface StorageService {
    Storage addStorage(Storage storage);

    Storage updateStorage(Storage storage);

    Set<Storage> getStorages();

    Storage getStorage(Long id);

    void deleteStorage(Long id);
}
