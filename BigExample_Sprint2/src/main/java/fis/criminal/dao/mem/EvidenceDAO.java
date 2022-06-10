package fis.criminal.dao.mem;

import fis.criminal.dao.IEvidenceDAO;
import fis.criminal.model.Evidence;

import java.util.List;
import java.util.Optional;

public class EvidenceDAO implements IEvidenceDAO {

    @Override
    public void save(Evidence evidence) {

    }

    @Override
    public Optional<Evidence> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<Evidence> getAll() {
        return null;
    }

    @Override
    public void update(Evidence evidence) {

    }

    @Override
    public void delete(Evidence evidence) {

    }
}
