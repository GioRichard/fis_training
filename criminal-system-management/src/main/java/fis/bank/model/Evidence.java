package fis.bank.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;
@Data
@Entity
@Table(name = "evidence")
public class Evidence extends  AbstractEntity{
    @OneToOne(cascade = CascadeType.ALL)
            @JoinColumn(name = "storageId")
    Storage storage;
    String number;
    String itemName;
    String notes;
    Boolean archived;

    @OneToMany(mappedBy = "evidence", cascade = CascadeType.ALL)
    Set<TrackEntry> trackEntries;

    @ManyToOne
    @JoinColumn(name = "criminalCaseId")
    CriminalCase criminalCase;

    public Evidence() {
    }
    public CriminalCase getCriminalCase() {
        return criminalCase;
    }

    public void setCriminalCase(CriminalCase criminalCase) {
        this.criminalCase = criminalCase;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Boolean getArchived() {
        return archived;
    }

    public void setArchived(Boolean archived) {
        this.archived = archived;
    }

    public Set<TrackEntry> getTrackEntries() {
        return trackEntries;
    }

    public void setTrackEntries(Set<TrackEntry> trackEntries) {
        this.trackEntries = trackEntries;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Evidence)) return false;
        Evidence evidence = (Evidence) o;
        return Objects.equals(criminalCase, evidence.criminalCase) && Objects.equals(storage, evidence.storage) && Objects.equals(number, evidence.number) && Objects.equals(itemName, evidence.itemName) && Objects.equals(notes, evidence.notes) && Objects.equals(archived, evidence.archived) && Objects.equals(trackEntries, evidence.trackEntries);
    }

    @Override
    public int hashCode() {
        return Objects.hash(criminalCase, storage, number, itemName, notes, archived, trackEntries);
    }

    @Override
    public String toString() {
        return "Evidence{" +
                "criminalCase=" + criminalCase +
                ", storage=" + storage +
                ", number='" + number + '\'' +
                ", itemName='" + itemName + '\'' +
                ", notes='" + notes + '\'' +
                ", archived=" + archived +
                ", trackEntries=" + trackEntries +
                '}';
    }
    public void replaceWith(Evidence evidence){
        this.criminalCase = evidence.getCriminalCase();
        this.storage = evidence.getStorage();
        this.number = evidence.getNumber();
        this.itemName = evidence.getItemName();
        this.notes = evidence.getNotes();
        this.archived = evidence.getArchived();
        this.trackEntries = evidence.getTrackEntries();
    }
}
