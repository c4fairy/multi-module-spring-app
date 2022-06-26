package ru.dina;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public List<PersonDto> getAllPersons() {
        log.info("Вызов метода findAll()");
        List<PersonDto> personsDto = new ArrayList<>();
        for (Person person: persons)
            personsDto.add(personMapper.personDtoToPerson(person));
        return personsDto;
    }

    @Override
    @PostMapping
    public void createNewPerson(PersonDto newPerson) {
        log.info("Вызов метода newPerson()");
        persons.add(personMapper.personToPersonDto(newPerson));
    }

    @Override
    @GetMapping("/{id}")
    public PersonDto findPersonById(Long id) {
        log.info("Вызов метода findById(id)");
        return personMapper.personDtoToPerson(persons.stream().filter(person -> person.getId()==id).findFirst().get());
    }

    @Override
    @PutMapping("/{id}")
    public void replacePerson(PersonDto newPerson, Long id) {
        log.info("Вызов метода replacePerson");
        int i = 0;
        for (Person person : persons) {
            if (person.getId() == id) {
                persons.set(i, personMapper.personToPersonDto(newPerson));
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
