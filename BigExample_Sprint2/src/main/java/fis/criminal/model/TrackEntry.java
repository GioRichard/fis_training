package fis.criminal.model;

import fis.criminal.model.enums.TrackAction;

import java.time.LocalDateTime;
import java.util.Objects;

public class TrackEntry extends AbstractEntity {
    LocalDateTime date;
    Evidence evidence;
    Detective detective;
    TrackAction action;
    String reason;

    public TrackEntry() {
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Evidence getEvidence() {
        return evidence;
    }

    public void setEvidence(Evidence evidence) {
        this.evidence = evidence;
    }

    public Detective getDetective() {
        return detective;
    }

    public void setDetective(Detective detective) {
        this.detective = detective;
    }

    public TrackAction getAction() {
        return action;
    }

    public void setAction(TrackAction action) {
        this.action = action;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TrackEntry)) return false;
        TrackEntry that = (TrackEntry) o;
        return Objects.equals(date, that.date) && Objects.equals(evidence, that.evidence) && Objects.equals(detective, that.detective) && action == that.action && Objects.equals(reason, that.reason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, evidence, detective, action, reason);
    }

    @Override
    public String toString() {
        return "TrackEntry{" +
                "date=" + date +
                ", evidence=" + evidence +
                ", detective=" + detective +
                ", action=" + action +
                ", reason='" + reason + '\'' +
                '}';
    }
    public void replaceWith(TrackEntry trackEntry) {
        this.date = trackEntry.getDate();
        this.evidence = trackEntry.getEvidence();
        this.detective = trackEntry.getDetective();
        this.action =trackEntry.getAction();
        this.reason = trackEntry.getReason();
    }
}
