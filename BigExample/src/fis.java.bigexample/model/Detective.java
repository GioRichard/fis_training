package fis.java.bigexample.model;

import fis.java.bigexample.model.enums.EmploymentStatus;
import fis.java.bigexample.model.enums.Rank;

import java.time.LocalDateTime;
import java.util.Set;

public class Detective extends  AbstractEntity {
    private String badgeNumber;
    private Rank rank;
    private  Boolean armed;
    private EmploymentStatus status;
    private Set<CriminalCase> criminalCases;
    private Set<TrackEntry> trackEntries;
    private  String userName;
    private String firstName;
    private String lastName;
    private String password;
    private LocalDateTime hiringDate;

    public Detective(String badgeNumber, Rank rank, Boolean armed, EmploymentStatus status, Set<CriminalCase> criminalCases,
                     Set<TrackEntry> trackEntries, String userName, String firstName, String lastName,
                     String password, LocalDateTime hiringDate) {
        this.badgeNumber = badgeNumber;
        this.rank = rank;
        this.armed = armed;
        this.status = status;
        this.criminalCases = criminalCases;
        this.trackEntries = trackEntries;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.hiringDate = hiringDate;
    }

    public Detective(long id, int version, LocalDateTime createdAt, LocalDateTime modifiedAr,
                     String badgeNumber, Rank rank, Boolean armed, EmploymentStatus status, Set<CriminalCase> criminalCases,
                     Set<TrackEntry> trackEntries, String userName, String firstName, String lastName, String password, LocalDateTime hiringDate) {
        super(id, version, createdAt, modifiedAr);
        this.badgeNumber = badgeNumber;
        this.rank = rank;
        this.armed = armed;
        this.status = status;
        this.criminalCases = criminalCases;
        this.trackEntries = trackEntries;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
}
