package fis.criminal.dao;

import fis.criminal.model.CriminalCase;

import java.util.List;
import java.util.Optional;

public interface IDao<T> {
    //CREATE
    void save(T t);

    //READ | RETRIEVE
    Optional<T> get(long id);
    List<T> getAll();

    //UPDATE
    List<CriminalCase> update(T t);

    //DELETE
    void delete(T t);

    //Other ...
}
