package fis.java.bigexample.model;

import java.time.LocalDateTime;

public abstract class AbstractEntity {
    private  long id;
    private int version;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAr;

    public AbstractEntity() {
    }

    public AbstractEntity(long id, int version, LocalDateTime createdAt, LocalDateTime modifiedAr) {
        this.id = id;
        this.version = version;
        this.createdAt = createdAt;
        this.modifiedAr = modifiedAr;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getModifiedAr() {
        return modifiedAr;
    }

    public void setModifiedAr(LocalDateTime modifiedAr) {
        this.modifiedAr = modifiedAr;
    }
}
