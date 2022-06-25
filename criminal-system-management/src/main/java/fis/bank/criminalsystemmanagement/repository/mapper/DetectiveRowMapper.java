package fis.bank.criminalsystemmanagement.repository.mapper;

import fis.bank.criminalsystemmanagement.model.Detective;
import fis.bank.criminalsystemmanagement.model.Person;
import fis.bank.criminalsystemmanagement.model.enums.EmploymentStatus;
import fis.bank.criminalsystemmanagement.model.enums.Rank;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DetectiveRowMapper implements RowMapper<Detective> {
    @Override
    public Detective mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("id");
        String badgeNumber = rs.getString("badge_number");
        String rank = rs.getString("rank");
        boolean armed = rs.getBoolean("armed");
        String status = rs.getString("employmentStatus");
        long personId = rs.getLong("person_id");

        Person person = new Person();
        person.setId(personId);
        person.setUserName(rs.getString("user_name"));
        person.setFirstName(rs.getString("first_name"));
        person.setLastName(rs.getString("last_name"));
        person.setHiringDate(rs.getTimestamp("hiring_date").toLocalDateTime());

        Detective detective = new Detective();
        detective.setId(id);
        detective.setPerson(person);
        detective.setBadgeNumber(badgeNumber);
        detective.setRank(Rank.valueOf(rank));
        detective.setArmed(armed);
        detective.setEmploymentStatus(EmploymentStatus.valueOf(status));
        return detective;
    }
}
