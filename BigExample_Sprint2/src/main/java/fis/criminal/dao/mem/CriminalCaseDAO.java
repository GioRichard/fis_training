package fis.criminal.dao.mem;

import fis.criminal.dao.ICriminalCaseDAO;
import fis.criminal.model.CriminalCase;

import java.util.List;
import java.util.Optional;

public class CriminalCaseDAO implements ICriminalCaseDAO {
    @Override
    public void save(CriminalCase criminalCase) {

       MemoryDataSource.CRIMINAL_CASES.add(criminalCase);
//        if(!MemoryDataSource.CRIMINAL_CASES.stream()
//                .filter(item -> item.getId()))
    }


    @Override
    public Optional<CriminalCase> get(long id) {
        return MemoryDataSource.CRIMINAL_CASES.stream()
                .filter(criminalCase -> criminalCase.getId()==id)
                .findFirst();
    }

    @Override
    public List<CriminalCase> getAll() {
        return MemoryDataSource.CRIMINAL_CASES;
    }

    @Override
    public List<CriminalCase> update(CriminalCase newCriminalCase) {
        Optional<CriminalCase> criminalCase = get(newCriminalCase.getId());
        if(criminalCase.isPresent()){
            CriminalCase updatedCriminalCase = criminalCase.get();
            updatedCriminalCase.replaceWith(newCriminalCase);
        }
        return null;
    }

    @Override
    public boolean delete(long id) {
        for(CriminalCase criminalCase : MemoryDataSource.CRIMINAL_CASES) {
            if (criminalCase.getId() == id){
                MemoryDataSource.CRIMINAL_CASES.remove(criminalCase);
                return false;
            }
        }
        return false;
    }

    @Override
    public void delete(CriminalCase criminalCase) {
        MemoryDataSource.CRIMINAL_CASES.remove(criminalCase);
    }
}