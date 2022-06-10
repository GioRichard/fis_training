package fis.criminal.model;

import fis.criminal.model.enums.CaseStatus;
import fis.criminal.model.enums.CaseType;

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

        if (number != null ? !number.equals(that.number) : that.number != null) return false;
        if (type != that.type) return false;
        if (shortDescription != null ? !shortDescription.equals(that.shortDescription) : that.shortDescription != null)
            return false;
        if (detailedDescription != null ? !detailedDescription.equals(that.detailedDescription) : that.detailedDescription != null)
            return false;
        if (status != that.status) return false;
        if (notes != null ? !notes.equals(that.notes) : that.notes != null) return false;
        if (evidenceSet != null ? !evidenceSet.equals(that.evidenceSet) : that.evidenceSet != null) return false;
        if (leadInvestigator != null ? !leadInvestigator.equals(that.leadInvestigator) : that.leadInvestigator != null)
            return false;
        return assigned != null ? assigned.equals(that.assigned) : that.assigned == null;
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
        this.notes = criminalCase.getNotes();
        this.status = criminalCase.getStatus();
        //....
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
