package fis.bank.criminalsystemmanagement.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name = "storages")
public class Storage extends AbstractEntity{
    @Column(name = "name")
    private String name;
    @Column(name = "location")
    private String location;
    @OneToMany(mappedBy = "storage")
    private Set<Evidence> evidenceSet;

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

    public Set<Evidence> getEvidenceSet() {
        return evidenceSet;
    }

    public void setEvidenceSet(Set<Evidence> evidenceSet) {
        this.evidenceSet = evidenceSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Storage)) return false;
        if (!super.equals(o)) return false;
        Storage storage = (Storage) o;
        return Objects.equals(name, storage.name) && Objects.equals(location, storage.location)
                && Objects.equals(evidenceSet, storage.evidenceSet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, location, evidenceSet);
    }

    @Override
    public String toString() {
        return "Storage{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", evidenceSet=" + evidenceSet +
                '}';
    }
}
