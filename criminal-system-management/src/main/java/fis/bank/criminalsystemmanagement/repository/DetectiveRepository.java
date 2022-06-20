package fis.bank.criminalsystemmanagement.repository;

import fis.bank.criminalsystemmanagement.model.Detective;
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
public class DetectiveRepository implements JpaRepository<Detective, Long> {
    @Override
    public List<Detective> findAll() {
        return null;
    }

    @Override
    public List<Detective> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Detective> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Detective> findAllById(Iterable<Long> longs) {
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
    public void delete(Detective entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Detective> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Detective> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Detective> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Detective> findById(Long aLong) {
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
    public <S extends Detective> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Detective> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Detective> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Detective getOne(Long aLong) {
        return null;
    }

    @Override
    public Detective getById(Long aLong) {
        return null;
    }

    @Override
    public Detective getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Detective> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Detective> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Detective> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Detective> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Detective> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Detective> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Detective, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}
