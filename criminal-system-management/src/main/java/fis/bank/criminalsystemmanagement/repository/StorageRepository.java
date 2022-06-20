package fis.bank.criminalsystemmanagement.repository;

import fis.bank.criminalsystemmanagement.model.Storage;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
public class StorageRepository implements JpaRepository<Storage,Long> {
    @Override
    public List<Storage> findAll() {
        return null;
    }

    @Override
    public List<Storage> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Storage> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Storage> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Storage entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Storage> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Storage> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Storage> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Storage> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Storage> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Storage> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Storage> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Storage getOne(Long aLong) {
        return null;
    }

    @Override
    public Storage getById(Long aLong) {
        return null;
    }

    @Override
    public Storage getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Storage> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Storage> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Storage> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Storage> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Storage> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Storage> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Storage, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}
