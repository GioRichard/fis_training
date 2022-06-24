package fis.bank.criminalsystemmanagement.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.InheritanceType.SINGLE_TABLE;

@MappedSuperclass

public class AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int version;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

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

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(LocalDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }
}
