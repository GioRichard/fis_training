package fis.criminal.dao.mem;

import fis.criminal.dao.IEvidenceDAO;
import fis.criminal.model.Detective;
import fis.criminal.model.Evidence;

import java.util.List;
import java.util.Optional;

public class EvidenceDAO implements IEvidenceDAO {

    @Override
    public void save(Evidence evidence) {
        MemoryDataSource.EVIDENCES.add(evidence);
    }

    @Override
    public Optional<Evidence> get(long id) {

        return MemoryDataSource.EVIDENCES.stream()
                .filter(evidence -> evidence.getId() ==id)
                .findFirst();
    }

    @Override
    public List<Evidence> getAll() {

        return MemoryDataSource.EVIDENCES;
    }

    @Override
    public List<Evidence> update(Evidence newEvidence) {

        Optional<Evidence> detective = get(newEvidence.getId());
        if(detective.isPresent()){
            Evidence updateEvidence = detective.get();
            updateEvidence.replaceWith(newEvidence);
        }
        return null;
    }

    @Override
    public void delete(Evidence evidence) {
        MemoryDataSource.EVIDENCES.remove(evidence);
    }
}
