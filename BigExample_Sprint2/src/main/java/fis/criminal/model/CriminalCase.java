package fis.criminal.model;

import fis.criminal.model.enums.CaseStatus;
import fis.criminal.model.enums.CaseType;

import java.util.Objects;
import java.util.Set;

public class CriminalCase extends AbstractEntity {
    String number;
    CaseType type;
    String shortDescription;
    String detailedDescription;
    CaseStatus status;
    String notes;
    Set<Evidence> evidenceSet;
    Detective leadInvestigator;
    Set<Detective> assigned;

    public CriminalCase() {
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
        return evidenceSet;
    }

    public void setEvidenceSet(Set<Evidence> evidenceSet) {
        this.evidenceSet = evidenceSet;
    }

    public Detective getLeadInvestigator() {
        return leadInvestigator;
    }

    public void setLeadInvestigator(Detective leadInvestigator) {
        this.leadInvestigator = leadInvestigator;
    }

    public Set<Detective> getAssigned() {
        return assigned;
    }

    public void setAssigned(Set<Detective> assigned) {
        this.assigned = assigned;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CriminalCase that = (CriminalCase) o;

        if (!Objects.equals(number, that.number)) return false;
        if (type != that.type) return false;
        if (!Objects.equals(shortDescription, that.shortDescription))
            return false;
        if (!Objects.equals(detailedDescription, that.detailedDescription))
            return false;
        if (status != that.status) return false;
        if (!Objects.equals(notes, that.notes)) return false;
        if (!Objects.equals(evidenceSet, that.evidenceSet)) return false;
        if (!Objects.equals(leadInvestigator, that.leadInvestigator))
            return false;
        return Objects.equals(assigned, that.assigned);
    }

    @Override
    public int hashCode() {
        int result = number != null ? number.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (shortDescription != null ? shortDescription.hashCode() : 0);
        result = 31 * result + (detailedDescription != null ? detailedDescription.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (notes != null ? notes.hashCode() : 0);
        result = 31 * result + (evidenceSet != null ? evidenceSet.hashCode() : 0);
        result = 31 * result + (leadInvestigator != null ? leadInvestigator.hashCode() : 0);
        result = 31 * result + (assigned != null ? assigned.hashCode() : 0);
        return result;
    }

    public void replaceWith(CriminalCase criminalCase){
        this.assigned = criminalCase.getAssigned();
        this.leadInvestigator = criminalCase.getLeadInvestigator();
        this.evidenceSet = criminalCase.getEvidenceSet();
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
                ", evidenceSet=" + evidenceSet +
                ", leadInvestigator=" + leadInvestigator +
                ", assigned=" + assigned +
                '}';
    }
}
