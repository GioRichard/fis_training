package fis.bank.criminalsystemmanagement.model;

import fis.bank.criminalsystemmanagement.model.enums.EmploymentStatus;
import fis.bank.criminalsystemmanagement.model.enums.Rank;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "detective")
public class Detective extends AbstractEntity{
    String badgeNumber;
    @Column(name = "`rank`")
    @Enumerated(EnumType.STRING)
    Rank rank;
    Boolean armed;
    @Enumerated(EnumType.STRING)
    EmploymentStatus status;
    @ManyToMany
    @JoinTable(
            name = "working_detective_case",
            joinColumns = @JoinColumn(name = "detectiveId"),
            inverseJoinColumns = @JoinColumn(name = "criminalCaseId"))
    Set<CriminalCase> criminalCases;

    @OneToMany(mappedBy = "detective", cascade = CascadeType.ALL)
    Set<TrackEntry> trackEntries;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "leadInvestigator")
      CriminalCase criminalCase;
    String username;
    String firstName;
    String lastName;
    String password;
    LocalDateTime hiringDate;
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getHiringDate() {
        return hiringDate;
    }

    public void setHiringDate(LocalDateTime hiringDate) {
        this.hiringDate = hiringDate;
    }


    public String getBadgeNumber() {
        return badgeNumber;
    }

    public void setBadgeNumber(String badgeNumber) {
        this.badgeNumber = badgeNumber;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public Boolean getArmed() {
        return armed;
    }

    public void setArmed(Boolean armed) {
        this.armed = armed;
    }

    public EmploymentStatus getStatus() {
        return status;
    }

    public void setStatus(EmploymentStatus status) {
        this.status = status;
    }

    public Set<CriminalCase> getCriminalCases() {
        return criminalCases;
    }

    public void setCriminalCases(Set<CriminalCase> criminalCases) {
        this.criminalCases = criminalCases;
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
        if (!(o instanceof Detective)) return false;
        Detective detective = (Detective) o;
        return Objects.equals(badgeNumber, detective.badgeNumber) && rank == detective.rank && Objects.equals(armed, detective.armed) && status == detective.status && Objects.equals(criminalCases, detective.criminalCases) && Objects.equals(trackEntries, detective.trackEntries) && Objects.equals(username, detective.username) && Objects.equals(firstName, detective.firstName) && Objects.equals(lastName, detective.lastName) && Objects.equals(password, detective.password) && Objects.equals(hiringDate, detective.hiringDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(badgeNumber, rank, armed, status, criminalCases, trackEntries, username, firstName, lastName, password, hiringDate);
    }

    @Override
    public String toString() {
        return "Detective{" +
                "badgeNumber='" + badgeNumber + '\'' +
                ", rank=" + rank +
                ", armed=" + armed +
                ", status=" + status +
                ", criminalCases=" + criminalCases +
                ", trackEntries=" + trackEntries +
                ", username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", hiringDate=" + hiringDate +
                '}';
    }

}
