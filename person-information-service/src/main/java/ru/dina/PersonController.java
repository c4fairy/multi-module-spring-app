package ru.dina;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.dina.dto.Person;
import ru.dina.dto.PersonDto;
import ru.dina.dto.PersonService;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/persons")
public class PersonController implements PersonService {

    private final List<Person> persons = List.of(new Person(1L, "Name1 Surname1", "Some address1"),
            new Person(2L, "Name2 Surname2", "Some address2"));

    private PersonMapper personMapper;

    @Autowired
    public PersonController(PersonMapper personMapper) {
        this.personMapper = personMapper;
    }

    @Override
    @GetMapping
    public List<Person> getAllPersons() {
        log.info("Вызов метода findAll()");
        return persons;
    }

    @Override
    @PostMapping
    public void createNewPerson(Person newPerson) {
        log.info("Вызов метода newPerson()");
        persons.add(newPerson);
    }

    @Override
    @GetMapping("/{id}")
    public Person findPersonById(Long id) {
        log.info("Вызов метода findById(id)");
        return persons.stream().filter(person -> person.getId()==id).findFirst().get();
    }

    @Override
    @PutMapping("/{id}")
    public void replacePerson(Person newPerson, Long id) {
        log.info("Вызов метода replacePerson");
        int i = 0;
        for (Person person : persons) {
            if (person.getId() == id) {
                persons.set(i, newPerson);
            }
            i++;
        }
    }

    @Override
    @DeleteMapping("/{id}")
    public void deletePersonById(Long id) {
        log.info("Вызов метода deleteById");
        persons.removeIf(person -> person.getId() == (id));
    }
}
