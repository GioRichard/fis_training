package fis.java.bigexample.dao.criminal;

import fis.java.bigexample.model.CriminalCase;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CriminalDAOMemlmpl implements ICriminalDAO {
    private List<CriminalCase> criminalCasesList = new ArrayList<>();
    private static CriminalDAOMemlmpl instance = new CriminalDAOMemlmpl();
    public static CriminalDAOMemlmpl getInstance(){
        return instance;
    }
    @Override
    public void add(CriminalCase criminalCase) {
        this.criminalCasesList.add(criminalCase);
    }

    @Override
    public CriminalCase get(long id) {
        Optional<CriminalCase> opt =
                this.criminalCasesList.stream().filter(item -> item.getId() == id ? true : false).findFirst();
        if (opt.isPresent())
            return opt.get();
        else
            return  null;
    }

    @Override
    public List<CriminalCase> getAll() {
        return this.criminalCasesList;
    }

    @Override
    public CriminalCase update(CriminalCase criminalCase) {

        return null;
    }

    @Override
    public CriminalCase remove(long id){
        for(CriminalCase criminalCase : this.criminalCasesList){
            if(criminalCase.getId() == id){
                this.criminalCasesList.remove(criminalCase);
                return criminalCase;
            }
        }
        return null;
    }
}
