package fis.bank.criminalsystemmanagement.repository.mapper;

import fis.bank.criminalsystemmanagement.model.CriminalCase;
import fis.bank.criminalsystemmanagement.model.Evidence;
import fis.bank.criminalsystemmanagement.model.Storage;
import fis.bank.criminalsystemmanagement.model.enums.CaseStatus;
import fis.bank.criminalsystemmanagement.model.enums.CaseType;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EvidenceRowMapper implements RowMapper<Evidence> {
    @Override
    public Evidence mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("id");
        boolean archived = rs.getBoolean("archived");
        String item = rs.getString("item");
        String notes = rs.getString("notes");
        String number = rs.getString("number");
        Integer version = rs.getInt("version");
        long criminalId = rs.getLong("case_id");
        long storageId = rs.getLong("storage_id");

        String caseStatus = rs.getString("case_status");
        String caseType = rs.getString("case_type");
        String shortDescription = rs.getString("short_description");
        String detailDescription = rs.getString("detail_description");

        String location = rs.getString("location");
        String name = rs.getString("name");

        CriminalCase criminalCase = new CriminalCase();
        criminalCase.setId(criminalId);
        criminalCase.setCaseStatus(CaseStatus.valueOf(caseStatus));
        criminalCase.setCaseType(CaseType.valueOf(caseType));
        criminalCase.setShortDescription(shortDescription);
        criminalCase.setDetailedDescription(detailDescription);

        Storage storage = new Storage();
        storage.setId(storageId);
        storage.setLocation(location);
        storage.setName(name);

        Evidence evidence = new Evidence();
        evidence.setId(id);
        evidence.setStorage(storage);
        evidence.setCriminalCase(criminalCase);
        evidence.setArchived(archived);
        evidence.setVersion(version);
        evidence.setItemName(item);
        evidence.setNotes(notes);
        evidence.setNumber(number);

        return evidence;
    }
}
