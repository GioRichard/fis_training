package fis.bank.criminalsystemmanagement.model;

import fis.bank.criminalsystemmanagement.model.enums.CaseStatus;
import fis.bank.criminalsystemmanagement.model.enums.CaseType;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;


@Entity
@Table(name = "criminalcase")
public class CriminalCase  extends  AbstractEntity{
    String number;
    CaseType type;
    String shortDescription;
    String detailedDescription;
    CaseStatus status;
    String notes;
    @ManyToMany(mappedBy = "criminalCases")
    Set<Detective> detectives;

    @OneToOne
    @JoinColumn(name = "criminalCase")
    Detective leadInvestigator;

    @OneToMany(mappedBy = "criminalCase", cascade = CascadeType.ALL)
    Set<Evidence> evidences;

    public CriminalCase(long l, int i, Object o, Object o1, String s, String dai, String ngan, Object o2, String note1, Object o3, Object o4) {
    }

    public CriminalCase(String number, CaseType type, String shortDescription, String detailedDescription,
                        CaseStatus status, String notes, Detective leadInvestigator) {
        this.number = number;
        this.type = type;
        this.shortDescription = shortDescription;
        this.detailedDescription = detailedDescription;
        this.status = status;
        this.notes = notes;
        this.leadInvestigator = leadInvestigator;
    }

    public CriminalCase(long id, int version, LocalDateTime createdAt, LocalDateTime modifiedAt, String number,
                        CaseType type, String shortDescription, String detailedDescription, CaseStatus status, String notes,
                        Set<Detective> detectives, Detective leadInvestigator, Set<Evidence> evidences) {
        super(id, version, createdAt, modifiedAt);
        this.number = number;
        this.type = type;
        this.shortDescription = shortDescription;
        this.detailedDescription = detailedDescription;
        this.status = status;
        this.notes = notes;
        this.detectives = detectives;
        this.leadInvestigator = leadInvestigator;
        this.evidences = evidences;
    }

    public Set<Detective> getDetectives() {
        return detectives;
    }

    public void setDetectives(Set<Detective> detectives) {
        this.detectives = detectives;
    }

    public Set<Evidence> getEvidences() {
        return evidences;
    }

    public void setEvidences(Set<Evidence> evidences) {
        this.evidences = evidences;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public CaseType getType() {
        return type;
    }

    public void setType(CaseType type) {
        this.type = type;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getDetailedDescription() {
        return detailedDescription;
    }

    public void setDetailedDescription(String detailedDescription) {
        this.detailedDescription = detailedDescription;
    }

    public CaseStatus getStatus() {
        return status;
    }

    public void setStatus(CaseStatus status) {
        this.status = status;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Set<Evidence> getEvidenceSet() {
        return evidences;
    }

    public void setEvidenceSet(Set<Evidence> evidenceSet) {
        this.evidences = evidenceSet;
    }

    public Detective getLeadInvestigator() {
        return leadInvestigator;
    }

    public void setLeadInvestigator(Detective leadInvestigator) {
        this.leadInvestigator = leadInvestigator;
    }

    public Set<Detective> getAssigned() {
        return detectives;
    }

    public void setAssigned(Set<Detective> assigned) {
        this.detectives = assigned;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CriminalCase that = (CriminalCase) o;

        if (number != null ? !number.equals(that.number) : that.number != null) return false;
        if (type != that.type) return false;
        if (shortDescription != null ? !shortDescription.equals(that.shortDescription) : that.shortDescription != null)
            return false;
        if (detailedDescription != null ? !detailedDescription.equals(that.detailedDescription) : that.detailedDescription != null)
            return false;
        if (status != that.status) return false;
        if (notes != null ? !notes.equals(that.notes) : that.notes != null) return false;
        if (evidences != null ? !evidences.equals(that.evidences) : that.evidences != null) return false;
        if (leadInvestigator != null ? !leadInvestigator.equals(that.leadInvestigator) : that.leadInvestigator != null)
            return false;
        return detectives != null ? detectives.equals(that.detectives) : that.detectives == null;
    }

    @Override
    public int hashCode() {
        int result = number != null ? number.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (shortDescription != null ? shortDescription.hashCode() : 0);
        result = 31 * result + (detailedDescription != null ? detailedDescription.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (notes != null ? notes.hashCode() : 0);
        result = 31 * result + (evidences != null ? evidences.hashCode() : 0);
        result = 31 * result + (leadInvestigator != null ? leadInvestigator.hashCode() : 0);
        result = 31 * result + (detectives != null ? detectives.hashCode() : 0);
        return result;
    }

    public void replaceWith(CriminalCase criminalCase){
        this.detectives = criminalCase.getAssigned();
        this.leadInvestigator = criminalCase.getLeadInvestigator();
        this.evidences = criminalCase.getEvidenceSet();
        this.number = criminalCase.getNumber();
        this.type = criminalCase.getType();
        this.detailedDescription = criminalCase.getDetailedDescription();
        this.shortDescription = criminalCase.getShortDescription();
        this.notes = criminalCase.getNotes();
        this.status = criminalCase.getStatus();
    }

    @Override
    public String toString() {
        return "CriminalCase{" +
                "number='" + number + '\'' +
                ", type=" + type +
                ", shortDescription='" + shortDescription + '\'' +
                ", detailedDescription='" + detailedDescription + '\'' +
                ", status=" + status +
                ", notes='" + notes + '\'' +
                ", evidenceSet=" + evidences +
                ", leadInvestigator=" + leadInvestigator +
                ", assigned=" + detectives +
                '}';
    }
}
