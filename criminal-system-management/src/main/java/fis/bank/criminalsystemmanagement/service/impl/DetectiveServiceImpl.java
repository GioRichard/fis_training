package fis.bank.criminalsystemmanagement.service.impl;

import fis.bank.criminalsystemmanagement.repository.DetectiveRepository;
import fis.bank.criminalsystemmanagement.service.DetectiveService;
import fis.bank.criminalsystemmanagement.model.Detective;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetectiveServiceImpl implements DetectiveService {
    @Autowired
    private DetectiveRepository detectiveRepository;
    @Override
    public Detective CreateDetective(Detective detective) {
        return detectiveRepository.save(detective);
    }

    @Override
    public Detective updateDetective(Detective detective) {
        return detectiveRepository.save(detective);
    }

    @Override
    public Detective deleteDetectiveById(Long id) {
        Optional<Detective> opt = detectiveRepository.findById(id);
        if(opt.isPresent())
            detectiveRepository.deleteById(id);
        else
            throw new IllegalArgumentException(String.format("ID khong ton tai: %s",id));
        return null;
    }

    @Override
    public List<Detective> getAll() {
        return detectiveRepository.findAll();
    }


    @Override
    public Optional<Detective> findById(Long id) {
        return detectiveRepository.findById(id);
    }
}
