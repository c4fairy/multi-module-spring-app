package ru.dina.dto;

import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface PersonService {
    @GetMapping()
    List<Person> getAllPersons();

    @PostMapping()
    Person createNewPerson(@RequestBody Person newPerson);

    @GetMapping("/{id}")
    Person findPersonById(@PathVariable Long id);


    @PutMapping("/{id}")
    Person replacePerson(@RequestBody Person newPerson, @PathVariable Long id);


    @DeleteMapping("/{id}")
    void deletePersonById(@PathVariable Long id);

}
