package fis.bank.criminalsystemmanagement.model;

import fis.bank.criminalsystemmanagement.model.enums.TrackAction;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
@Data
@Entity
@Table(name = "trackentry")
public class TrackEntry extends AbstractEntity{
    @Column(name = "trackDate")
    LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "evidenceId")
    Evidence evidence;

    @ManyToOne
    @JoinColumn(name = "detectiveId")
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
}
