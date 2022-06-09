package fis.java.bigexample.dao.criminal;

import fis.java.bigexample.model.CriminalCase;
import fis.java.bigexample.model.Detective;

import java.util.List;

public interface ICriminalDAO {
    //Create Functions C
    public void add(CriminalCase criminalCase);

    //Retrieve Functions R
    public CriminalCase get(long id);
    public List<CriminalCase> getAll();

    //Update Functions U
    public CriminalCase update(CriminalCase criminalCase);

    //Delete Functions D
    public CriminalCase remove(long id);

    //Other Functions

}
