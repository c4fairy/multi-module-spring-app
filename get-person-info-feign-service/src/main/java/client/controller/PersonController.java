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
public class PersonController{
    private final PersonClient personClient;

    @GetMapping
    List<Person> getAllPersons() {
        return personClient.getAllPersons();
    }

    @PostMapping
    Person createNewPerson(@RequestBody Person newPerson) {
        return personClient.createNewPerson(newPerson);
    }

    @GetMapping("/{id}")
    Person findPersonById(@PathVariable Long id) {
        return personClient.findPersonById(id);
    }


    @PutMapping("/{id}")
    Person replacePerson(@RequestBody Person newPerson, @PathVariable Long id) {
        return personClient.replacePerson(newPerson, id);
    }

    @DeleteMapping("/{id}")
    void deletePersonById(@PathVariable Long id) {
        personClient.deletePersonById(id);
    }
}
