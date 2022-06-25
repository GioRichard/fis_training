package fis.bank.criminalsystemmanagement.repository.impl;

import fis.bank.criminalsystemmanagement.model.Detective;
import fis.bank.criminalsystemmanagement.model.Person;
import fis.bank.criminalsystemmanagement.model.enums.EmploymentStatus;
import fis.bank.criminalsystemmanagement.model.enums.Rank;
import fis.bank.criminalsystemmanagement.repository.PersonRepository;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DetectiveRepositoryImplTest {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    @Qualifier("ExtraDetectiveRepositoryImpl")
    private DetectiveRepositoryImpl detectiveRepository;

    @Test
    @Order(1)
    void create() {
        Person person = new Person();
        person.setUserName("Phong");
        person.setFirstName("Ha");
        person.setLastName("HaPhong");
        person.setPassword("9999");
        personRepository.save(person);
        Detective detective = new Detective();
        detective.setRank(Rank.TRAINEE);
        detective.setEmploymentStatus(EmploymentStatus.ACTIVE);
        detective.setArmed(true);
        detective.setBadgeNumber("B09");
        detective.setPerson(person);
        detectiveRepository.create(detective);
    }

    @Test
    @Order(2)
    void getALl() {
        detectiveRepository.getALl().forEach(System.out::println);
    }

    @Test
    @Order(3)
    void findById() {
        System.out.println(detectiveRepository.findById(1L));
    }

    @Test
    @Order(4)
    void update() {
        Detective detective = new Detective();
        detective.setId(1L);
        detective.setVersion(2);
        detective.setArmed(true);
        detective.setEmploymentStatus(EmploymentStatus.UNDER_INVESTIGATION);
        detective.setRank(Rank.INSPECTOR);
        detectiveRepository.update(detective);
    }

    @Test
    @Order(5)
    void deleteById() {
        detectiveRepository.deleteById(3L);
    }
}