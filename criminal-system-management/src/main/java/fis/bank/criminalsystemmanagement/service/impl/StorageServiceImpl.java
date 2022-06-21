package fis.bank.criminalsystemmanagement.service.impl;

import fis.bank.criminalsystemmanagement.repository.StorageRepository;
import fis.bank.criminalsystemmanagement.service.StorageService;
import fis.bank.criminalsystemmanagement.model.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StorageServiceImpl implements StorageService {

    @Autowired
    private StorageRepository storageRepository;

    @Override
    public Storage CreateStorage(Storage storage) {
        storageRepository.save(storage);
        return storage;
    }

    @Override
    public Storage updateStorage(Storage storage) {
        return storageRepository.save(storage);
    }

    @Override
    public Storage deleteStorageById(Long id) {
        Optional<Storage> opt = storageRepository.findById(id);
        if(opt.isPresent())
            storageRepository.deleteById(id);
        else
            throw new IllegalArgumentException(String.format("ID khong ton tai: %s",id));
        return null;
    }

    @Override
    public List<Storage> fillAll() {
        return storageRepository.findAll();
    }

    @Override
    public Optional<Storage> findById(Long id) {
        return storageRepository.findById(id);
    }
}
