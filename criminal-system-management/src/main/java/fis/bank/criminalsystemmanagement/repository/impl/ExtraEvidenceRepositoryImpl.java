package fis.bank.criminalsystemmanagement.repository.impl;

import fis.bank.criminalsystemmanagement.model.CriminalCase;
import fis.bank.criminalsystemmanagement.model.Evidence;
import fis.bank.criminalsystemmanagement.model.Storage;
import fis.bank.criminalsystemmanagement.model.enums.CaseStatus;
import fis.bank.criminalsystemmanagement.model.enums.CaseType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository("ExtraEvidenceRepositoryImpl")
public class ExtraEvidenceRepositoryImpl extends EvidenceRepositoryImpl{

    public ExtraEvidenceRepositoryImpl(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    private class EvidenceExtractor implements ResultSetExtractor<Evidence> {
        @Override
        public Evidence extractData(ResultSet rs) throws SQLException {
            Evidence evidence = null;
            while (rs.next()) {
                if (evidence == null) {
                    evidence = new Evidence();
                    evidence.setId(rs.getLong("id"));
                    evidence.setNumber(rs.getString("number"));
                    evidence.setArchived(rs.getBoolean("archived"));
                    evidence.setNotes(rs.getString("notes"));
                    evidence.setItemName(rs.getString("item"));
                    evidence.setVersion(rs.getInt("version"));
                }
                    CriminalCase criminalCase = new CriminalCase();
                    criminalCase.setId(rs.getLong("id"));
                    criminalCase.setCaseType(CaseType.valueOf(rs.getString("case_type")));
                    criminalCase.setCaseStatus(CaseStatus.valueOf(rs.getString("case_status")));
                    criminalCase.setDetailedDescription(rs.getString("detailDescription"));
                    criminalCase.setShortDescription(rs.getString("shortDescription"));
                    evidence.setCriminalCase(criminalCase);

                Storage storage = new Storage();
                storage.setName(rs.getString("name"));
                storage.setLocation(rs.getString("location"));
                evidence.setStorage(storage);
                }

                return evidence;
            }
        }
}