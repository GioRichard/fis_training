package fis.bank.criminalsystemmanagement.repository;

import fis.bank.criminalsystemmanagement.model.AbstractEntity;

import java.util.Set;

public interface AbstractRepoRepository<T extends AbstractEntity> {
    void create(T obj);

    Set<T> getALl();

    T findById(Long id);

    T update(T obj);

    void deleteById(Long id);
}
