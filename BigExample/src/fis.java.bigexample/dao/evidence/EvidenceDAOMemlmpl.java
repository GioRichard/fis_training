package fis.java.bigexample.dao.evidence;
import fis.java.bigexample.model.Evidence;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EvidenceDAOMemlmpl implements IEvidenceDAO {
    private List<Evidence> evidenceList = new ArrayList<>();
    private static EvidenceDAOMemlmpl instance = new EvidenceDAOMemlmpl();

    public static EvidenceDAOMemlmpl getInstance(){
        return instance;
    }
    @Override
    public void add(Evidence evidence) {
        this.evidenceList.add(evidence);
    }

    @Override
    public Evidence get(long id) {
        Optional<Evidence> opt =
                this.evidenceList.stream().filter(item -> item.getId() == id ? true : false).findFirst();
        if (opt.isPresent())
            return opt.get();
        else
            return  null;
    }

    @Override
    public List<Evidence> getAll() {
        return this.evidenceList;
    }

    @Override
    public Evidence update(Evidence evidence) {
        return null;
    }

    @Override
    public Evidence remove(long id) {
        for(Evidence evidence : this.evidenceList){
            if(evidence.getId() == id){
                this.evidenceList.remove(evidence);
                return evidence;
            }
        }
        return null;
    }
}
