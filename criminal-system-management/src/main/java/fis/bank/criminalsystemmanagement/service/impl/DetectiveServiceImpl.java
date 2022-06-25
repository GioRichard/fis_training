package fis.bank.criminalsystemmanagement.service.impl;

import fis.bank.criminalsystemmanagement.model.Detective;
import fis.bank.criminalsystemmanagement.repository.DetectiveRepository;
import fis.bank.criminalsystemmanagement.service.DetectiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class DetectiveServiceImpl implements DetectiveService {
    @Autowired
    @Qualifier("ExtraDetectiveRepositoryImpl")
    private DetectiveRepository detectiveRepo;
    @Override
    public void create(Detective detective) {
        detectiveRepo.create(detective);
    }

    @Override
    public Set<Detective> getALl() {
        return detectiveRepo.getALl();
    }

    @Override
    public Detective findById(Long id) {
        return detectiveRepo.findById(id);
    }

    @Override
    public Detective update(Detective detective) {
        return detectiveRepo.update(detective);
    }

    @Override
    public void deleteById(Long id) {
        detectiveRepo.deleteById(id);
    }
}
