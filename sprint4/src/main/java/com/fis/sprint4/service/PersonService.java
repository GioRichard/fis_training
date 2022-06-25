package com.fis.sprint4.service;

import com.fis.sprint4.model.Person;
import com.fis.sprint4.security.model.UserRole;

import java.util.Set;

public interface PersonService {
    Person createUser(Person user, Set<UserRole> userRoles) throws Exception;

    Person addPerson(Person person);

    Person updatePerson(Person person);

    Set<Person> getPeople();

    Person getPerson(Long id);

    void deletePerson(Long id);
}

