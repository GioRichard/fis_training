package fis.criminal.dao.mem;

import fis.criminal.dao.IDetectiveDAO;
import fis.criminal.model.Detective;

import java.util.List;
import java.util.Optional;

public class DetectiveDAO implements IDetectiveDAO {

    @Override
    public void save(Detective detective) {
        MemoryDataSource.DETECTIVES.add(detective);
    }

    @Override
    public Optional<Detective> get(long id) {
        return MemoryDataSource.DETECTIVES.stream()
                .filter(detective -> detective.getId() == id)
                .findFirst();
    }

    @Override
    public List<Detective> getAll() {
        return MemoryDataSource.DETECTIVES;
    }

    @Override
    public List<Detective> update(Detective newDetective) {
        Optional<Detective> detective = get(newDetective.getId());
        if(detective.isPresent()){
            Detective updateDetective = detective.get();
            updateDetective.replaceWith(newDetective);
        }
        return null;

    }

    @Override
    public Detective delete(Detective detective) {
        MemoryDataSource.DETECTIVES.remove(detective);
        return null;
    }
}
