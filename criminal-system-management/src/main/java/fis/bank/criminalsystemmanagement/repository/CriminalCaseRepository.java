package fis.bank.criminalsystemmanagement.repository;

import fis.bank.criminalsystemmanagement.model.CriminalCase;
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
public class CriminalCaseRepository implements JpaRepository<CriminalCase, Long> {
    @Override
    public List<CriminalCase> findAll() {
        return null;
    }

    @Override
    public List<CriminalCase> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<CriminalCase> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<CriminalCase> findAllById(Iterable<Long> longs) {
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
    public void delete(CriminalCase entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends CriminalCase> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends CriminalCase> S save(S entity) {
        return null;
    }

    @Override
    public <S extends CriminalCase> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<CriminalCase> findById(Long aLong) {
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
    public <S extends CriminalCase> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends CriminalCase> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<CriminalCase> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public CriminalCase getOne(Long aLong) {
        return null;
    }

    @Override
    public CriminalCase getById(Long aLong) {
        return null;
    }

    @Override
    public CriminalCase getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends CriminalCase> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends CriminalCase> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends CriminalCase> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends CriminalCase> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends CriminalCase> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends CriminalCase> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends CriminalCase, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}
