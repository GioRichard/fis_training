package com.pluralsight.persistence.module05.model.repos;

import com.pluralsight.persistence.module05.model.Author;
import com.pluralsight.persistence.module05.model.CD;

import java.util.List;

public interface ICdRepos {
    public List<CD> getAll();
}
