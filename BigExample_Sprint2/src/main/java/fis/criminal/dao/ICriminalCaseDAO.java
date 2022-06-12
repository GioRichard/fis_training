package fis.criminal.dao;

import fis.criminal.model.CriminalCase;

public interface ICriminalCaseDAO extends IDao<CriminalCase> {
    public boolean delete(long id);
}
