package fis.bank.criminalsystemmanagement.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

import static javax.persistence.InheritanceType.SINGLE_TABLE;

@MappedSuperclass
public class AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    @Column(name = "version")
    protected int version = 1;
    @Column(name = "create_time")
    protected LocalDateTime createdAt;
    @Column(name = "modify_time")
    protected LocalDateTime modifiedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractEntity)) return false;
        AbstractEntity that = (AbstractEntity) o;
        return version == that.version && Objects.equals(id, that.id) && Objects.equals(createdAt, that.createdAt) && Objects.equals(modifiedAt, that.modifiedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, version, createdAt, modifiedAt);
    }

    @Override
    public String toString() {
        return "AbstractEntity{" +
                "id=" + id +
                ", version=" + version +
                ", createdAt=" + createdAt +
                ", modifiedAt=" + modifiedAt +
                '}';
    }
}
