package ru.dina;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface PersonService {
    @GetMapping()
    List<PersonDto> getAllPersons();

    @PostMapping()
    void createNewPerson(@RequestBody PersonDto newPerson);

    @GetMapping("/{id}")
    PersonDto findPersonById(@PathVariable("id") Long id);

    @PutMapping("/{id}")
    void replacePerson(@RequestBody PersonDto newPerson, @PathVariable("id") Long id);

    @DeleteMapping("/{id}")
    void deletePersonById(@PathVariable("id") Long id);
}
