package com.pluralsight.persistence.module05.model.repos;

import com.pluralsight.persistence.module05.model.Author;

import java.util.List;

public interface IAuthorRepos {
    public List<Author> getAll();
}
