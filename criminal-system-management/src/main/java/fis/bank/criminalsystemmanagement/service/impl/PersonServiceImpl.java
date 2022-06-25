package fis.bank.criminalsystemmanagement.service.impl;

import fis.bank.criminalsystemmanagement.model.Person;
import fis.bank.criminalsystemmanagement.repository.PersonRepository;
import fis.bank.criminalsystemmanagement.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;

public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonRepository personRepository;
    @Override
    public void create(Person person) {
        personRepository.save(person);
    }
}
