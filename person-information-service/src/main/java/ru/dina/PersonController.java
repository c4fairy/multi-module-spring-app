package ru.dina;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.dina.dto.Person;
import ru.dina.dto.PersonService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/persons")
public class PersonController implements PersonService {
    private final PersonRepository repository;

    PersonController(PersonRepository repository) {
        this.repository = repository;
    }

 @Override
 @GetMapping
    public List<Person> getAllPersons() {
        log.info("Вызов метода findAll()");
        return repository.findAll();
    }

    @Override
    @PostMapping
    public Person createNewPerson(Person newPerson) {
        log.info("Вызов метода newPerson()");
        return repository.save(newPerson);
    }

    @Override
    @GetMapping("/{id}")
    public Person findPersonById(Long id) {
        log.info("Вызов метода findById(id)");
        return repository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
    }

    @Override
    @PutMapping("/{id}")
    public Person replacePerson(Person newPerson, Long id) {
        log.info("Вызов метода replacePerson");
        return repository.findById(id)
                .map(person -> {
                    person.setName(newPerson.getName());
                    person.setAdress(newPerson.getAdress());
                    return repository.save(person);
                })
                .orElseGet(() -> {
                    newPerson.setId(id);
                    return repository.save(newPerson);
                });
    }

    @Override
    @DeleteMapping("/{id}")
    public void deletePersonById(Long id) {
        log.info("Вызов метода deleteById");
        repository.deleteById(id);
    }
}
