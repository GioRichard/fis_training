package fis.bank.criminalsystemmanagement.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "storage")
public class Storage extends AbstractEntity{
    String name;
    String location;

    @OneToOne(mappedBy = "storage")
    private Evidence evidence;

    public Storage() {
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
}
