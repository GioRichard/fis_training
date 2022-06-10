package fis.criminal.dao.jdbc;

import fis.criminal.dao.IDetectiveDAO;
import fis.criminal.model.Detective;

import java.util.List;
import java.util.Optional;

public class JDBCDetectiveDAO implements IDetectiveDAO {
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
    public void update(Detective detective) {

    }

    @Override
    public void delete(Detective detective) {

    }
}
