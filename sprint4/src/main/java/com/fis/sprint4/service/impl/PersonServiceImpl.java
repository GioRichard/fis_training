package com.fis.sprint4.service.impl;

import com.fis.sprint4.model.Person;
import com.fis.sprint4.repository.PersonRepository;
import com.fis.sprint4.security.model.UserRole;
import com.fis.sprint4.security.repository.RoleRepository;
import com.fis.sprint4.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    PersonRepository personRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Person createUser(Person user, Set<UserRole> userRoles) throws Exception {
        Person local = personRepository.findByUsername(user.getUsername());
        if (local != null) {
            System.out.println("User is already there");
            throw new RuntimeException("User with this User name is already is already in DB !! try with anther one");
        } else {
            for (UserRole ur : userRoles) {
                roleRepository.save(ur.getRole());
            }
            user.getUserRoles().addAll(userRoles);
            local = this.personRepository.save(user);
        }
        return local;
    }

    @Override
    public Person addPerson(Person person) {
        return this.personRepository.save(person);
    }

    @Override
    public Person updatePerson(Person person) {
        return this.personRepository.save(person);
    }

    @Override
    public Set<Person> getPeople() {
        return new HashSet<>(this.personRepository.findAll());
    }

    @Override
    public Person getPerson(Long id) {
        return this.personRepository.findById(id).get();
    }

    @Override
    public void deletePerson(Long id) {
        Person person = new Person();
        person.setId(id);
        this.personRepository.delete(person);
    }



}
