package fis.criminal.model;

import java.util.Objects;

public class Storage extends AbstractEntity {
    String name;
    String location;

    public Storage() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Storage)) return false;
        Storage storage = (Storage) o;
        return Objects.equals(name, storage.name) && Objects.equals(location, storage.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, location);
    }

    @Override
    public String toString() {
        return "Storage{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
    public void replaceWith(Storage storage) {
        this.name = storage.getName();
        this.location = storage.getLocation();
    }
}
