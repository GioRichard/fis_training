package fis.bank.criminalsystemmanagement.service.impl;

import fis.bank.criminalsystemmanagement.repository.StorageRepository;
import fis.bank.criminalsystemmanagement.service.StorageService;
import fis.bank.criminalsystemmanagement.model.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class StorageServiceImpl implements StorageService {


    @Override
    public void create(Storage storage) {

    }

    @Override
    public Set<Storage> getALl() {
        return null;
    }

    @Override
    public Storage findById(Long id) {
        return null;
    }

    @Override
    public Storage update(Storage storage) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
