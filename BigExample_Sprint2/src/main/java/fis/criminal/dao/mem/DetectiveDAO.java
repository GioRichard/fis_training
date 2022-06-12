package fis.criminal.dao.mem;

import fis.criminal.dao.IDetectiveDAO;
import fis.criminal.model.CriminalCase;
import fis.criminal.model.Detective;

import java.util.List;
import java.util.Optional;

public class DetectiveDAO implements IDetectiveDAO {

    @Override
    public void save(Detective detective) {

    }

    @Override
    public Optional<Detective> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<Detective> getAll() {
        return null;
    }

    @Override
    public List<CriminalCase> update(Detective detective) {

        return null;
    }

    @Override
    public void delete(Detective detective) {

    }
}
