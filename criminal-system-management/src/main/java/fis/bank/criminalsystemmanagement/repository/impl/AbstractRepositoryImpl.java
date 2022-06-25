package fis.bank.criminalsystemmanagement.repository.impl;

import fis.bank.criminalsystemmanagement.core.NotImplementedException;
import fis.bank.criminalsystemmanagement.model.AbstractEntity;
import fis.bank.criminalsystemmanagement.model.Detective;
import fis.bank.criminalsystemmanagement.repository.AbstractRepoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Set;

public class AbstractRepositoryImpl<T extends AbstractEntity> implements AbstractRepoRepository<T> {

    @Autowired
    protected JdbcTemplate jdbcTemplate;

    public AbstractRepositoryImpl(JdbcTemplate jdbcTemplate) {

        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(T obj) {
        throw new NotImplementedException("Not needed for this implementation.");
    }

    @Override
    public Set<Detective> getALl() {
        throw new NotImplementedException("Not needed for this implementation.");
    }

    @Override
    public T findById(Long id) {
        throw new NotImplementedException("Not needed for this implementation.");
    }

    @Override
    public T update(T obj) {
        throw new NotImplementedException("Not needed for this implementation.");
    }

    @Override
    public void deleteById(Long id) {
        throw new NotImplementedException("Not needed for this implementation.");
    }
}
