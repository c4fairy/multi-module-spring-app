package client.controller;

import client.PersonClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.dina.dto.Person;
import ru.dina.dto.PersonService;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/persons")
public class PersonController implements PersonService{
    private final PersonClient personClient;

    @Override
    @GetMapping
    public List<Person> getAllPersons() {
        return personClient.getAllPersons();
    }

    @Override
    @PostMapping
    public Person createNewPerson(@RequestBody Person newPerson) {
        return personClient.createNewPerson(newPerson);
    }

    @Override
    @GetMapping("/{id}")
    public Person findPersonById(@PathVariable Long id) {
        return personClient.findPersonById(id);
    }


    @Override
    @PutMapping("/{id}")
    public Person replacePerson(@RequestBody Person newPerson, @PathVariable Long id) {
        return personClient.replacePerson(newPerson, id);
    }
    @Override
    @DeleteMapping("/{id}")
    public void deletePersonById(@PathVariable Long id) {
        personClient.deletePersonById(id);
    }
}
