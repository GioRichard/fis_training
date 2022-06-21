package fis.bank.criminalsystemmanagement.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;


@Entity
@Table(name = "storage")
public class Storage extends AbstractEntity{
    String name;
    String location;

    @OneToOne(mappedBy = "storage")
    private Evidence evidence;

    public Storage(long l, String s) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Evidence getEvidence() {
        return evidence;
    }

    public void setEvidence(Evidence evidence) {
        this.evidence = evidence;
    }

    public Storage(String name, String location, Evidence evidence) {
        this.name = name;
        this.location = location;
        this.evidence = evidence;
    }

    public Storage() {
    }

    public Storage(long id, int version, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        super(id, version, createdAt, modifiedAt);
    }

    public Storage(long id, int version, LocalDateTime createdAt, LocalDateTime modifiedAt, String name, String location, Evidence evidence) {
        super(id, version, createdAt, modifiedAt);
        this.name = name;
        this.location = location;
        this.evidence = evidence;
    }
}
