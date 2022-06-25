package fis.bank.criminalsystemmanagement.service.impl;

import fis.bank.criminalsystemmanagement.model.Detective;
import fis.bank.criminalsystemmanagement.model.Person;
import fis.bank.criminalsystemmanagement.model.enums.EmploymentStatus;
import fis.bank.criminalsystemmanagement.model.enums.Rank;
import fis.bank.criminalsystemmanagement.service.DetectiveService;
import fis.bank.criminalsystemmanagement.service.PersonService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DetectiveServiceImplTest {
    @Autowired
    private DetectiveService detectiveService;
    @Autowired
    private PersonService personService;

    @Test
    @Order(1)
    void create() {
        Person person = new Person();
        person.setUserName("Phong");
        person.setFirstName("Ha");
        person.setLastName("Quoc");
        person.setPassword("666");
        personService.create(person);
        Detective detective = new Detective();
        detective.setRank(Rank.INSPECTOR);
        detective.setEmploymentStatus(EmploymentStatus.RETIRED);
        detective.setArmed(true);
        detective.setBadgeNumber("DT001");
        detective.setPerson(person);
        detectiveService.create(detective);
    }

    @Test
    @Order(2)
    void getALl() {
        Assertions.assertEquals(2, detectiveService.getALl().size());
        detectiveService.getALl().forEach(System.out::println);
    }

    @Test
    @Order(3)
    void findById() {
        Detective detective = detectiveService.findById(1L);
        Assertions.assertEquals(Rank.CHIEF_INSPECTOR, detective.getRank());
        Assertions.assertEquals("dat", detective.getPerson().getLastName());
        System.out.println(detective);
    }

    @Test
    @Order(4)
    void update() {
        Detective detective = detectiveService.findById(1L);
        Detective detective1 = detectiveService.findById(2L);
        detective.setVersion(1);
        detective1.setArmed(false);
        detectiveService.update(detective);
        detectiveService.update(detective1);
        Assertions.assertEquals(1, detective.getVersion());
        Assertions.assertFalse(detective1.getArmed());
    }

    @Test
    @Order(5)
    void deleteById() {
        detectiveService.deleteById(3L);
        Assertions.assertNotEquals(3, detectiveService.getALl().size());
    }

}