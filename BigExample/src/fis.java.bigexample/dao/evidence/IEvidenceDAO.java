package fis.java.bigexample.dao.evidence;

import fis.java.bigexample.model.CriminalCase;
import fis.java.bigexample.model.Detective;
import fis.java.bigexample.model.Evidence;

import java.util.List;

public interface IEvidenceDAO {
    //Create Functions C
    public void add(Evidence evidence);

    //Retrieve Functions R
    public Evidence get(long id);
    public List<Evidence> getAll();

    //Update Functions U
    public Evidence update(Evidence evidence);

    //Delete Functions D
    public Evidence remove(long id);

    //Other Functions
}
