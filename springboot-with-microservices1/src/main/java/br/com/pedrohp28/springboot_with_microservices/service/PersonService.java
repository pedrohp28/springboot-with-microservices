package br.com.pedrohp28.springboot_with_microservices.service;

import br.com.pedrohp28.springboot_with_microservices.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {
  private final AtomicLong counter = new AtomicLong();
  private Logger logger = Logger.getLogger(PersonService.class.getName());

  public List<Person> findAll() {
    logger.info("Finding all people!");
    List<Person> listPerson = new ArrayList<Person>();
    for (int i = 0; i < 8; i++) {
      Person person = mockPerson(i);
      listPerson.add(person);
    }

    return listPerson;
  }

  public Person findById(String id) {
    logger.info("Finding one person!");

    Person person = new Person();
    person.setId(counter.incrementAndGet());
    person.setFirstName("Pedro");
    person.setLastName("Henrique");
    person.setAddress("Rua dos bobos, 0");
    person.setGender("Male");

    return person;
  }

  public Person create(Person person) {
    logger.info("Creating one person!");
    return person;
  }

  public Person update(Person person) {
    logger.info("Updating one person!");
    return person;
  }

  public void delete(String id) {
    logger.info("Deleting one person!");
  }

  private Person mockPerson(int i) {
    Person person = new Person();
    person.setId(counter.incrementAndGet());
    person.setFirstName("Firstname" + i);
    person.setLastName("Lastname" + i);
    person.setAddress("Some address in Brasil" + i);
    person.setGender("Male");
    return person;
  }
}
