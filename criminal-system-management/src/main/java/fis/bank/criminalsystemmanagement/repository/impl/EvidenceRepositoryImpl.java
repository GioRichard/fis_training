package fis.bank.criminalsystemmanagement.repository.impl;

import fis.bank.criminalsystemmanagement.model.Evidence;
import fis.bank.criminalsystemmanagement.repository.EvidenceRepository;
import fis.bank.criminalsystemmanagement.repository.mapper.EvidenceRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Repository
public class EvidenceRepositoryImpl extends AbstractRepositoryImpl<Evidence> implements EvidenceRepository {
    public EvidenceRepositoryImpl(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }
    private RowMapper<Evidence> rowMapper = new EvidenceRowMapper();

    @Override
    public void create(Evidence evidence) {
        jdbcTemplate.update(
                "insert into evidences(id, create_time, modify_time,version, archived, item," +
                        " notes, number,case_id,storage_id) " +
                        "values(?,?,?,?,?,?,?,?,?,?)",
                evidence.getId(), LocalDateTime.now(), LocalDateTime.now(), evidence.getVersion(), evidence.isArchived()
                ,evidence.getItemName(),evidence.getNotes(),
                evidence.getCriminalCase().getId(), evidence.getStorage().getId()
        );
    }

    @Override
    public Set<Evidence> getALl() {
        String sql = "select e.id, e.item, e.archived, e.notes, e.number, e.case_id, " +
                "e.storage_id, e.version, c.caseStatus,c.caseType," +
                " c.shortDescription,c.detailDescription, s.location, s.name" +
                " FROM evidences e, criminal_case c, storages s  " +
                "WHERE s.storage_id = e.id and  c.case_id = e.id";
        return new HashSet<>(jdbcTemplate.query(sql, rowMapper));
    }

    @Override
    public Evidence findById(Long id) {
        String sql = "select e.id, e.item, e.archived, e.notes, e.number, e.case_id, " +
                "e.storage_id, e.version, c.caseStatus,c.caseType," +
                " c.shortDescription,c.detailDescription, s.location, s.name" +
                " FROM evidences e, criminal_case c, storages s  " +
                "WHERE e.id = ? and s.storage_id = e.id and  c.case_id = e.id";
        return jdbcTemplate.queryForObject(sql, rowMapper, id);
    }

    @Override
    public Evidence update(Evidence evidence) {
        jdbcTemplate.update("UPDATE evidences e SET e.modify_time = now(), e.version = ?, e.archived = ?, " +
                        "e.notes = ?, e.number = ?, e.item = ? WHERE d.id = ?",
                evidence.getVersion(), evidence.isArchived(),evidence.getNotes(),evidence.getNumber(),evidence.getItemName(),
                evidence.getId());
        return evidence;
    }

    @Override
    public void deleteById(Long id) {
        jdbcTemplate.update("delete from evidences where id =? ", id);
    }

}
