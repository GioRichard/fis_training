package fis.bank.criminalsystemmanagement.repository;

import fis.bank.criminalsystemmanagement.model.Evidence;
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
public class EvidenceRepository implements JpaRepository<Evidence,Long> {
    @Override
    public List<Evidence> findAll() {
        return null;
    }

    @Override
    public List<Evidence> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Evidence> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Evidence> findAllById(Iterable<Long> longs) {
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
    public void delete(Evidence entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Evidence> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Evidence> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Evidence> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Evidence> findById(Long aLong) {
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
    public <S extends Evidence> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Evidence> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Evidence> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Evidence getOne(Long aLong) {
        return null;
    }

    @Override
    public Evidence getById(Long aLong) {
        return null;
    }

    @Override
    public Evidence getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Evidence> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Evidence> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Evidence> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Evidence> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Evidence> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Evidence> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Evidence, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}