package client.controller;

import client.PersonClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.dina.PersonDto;
import ru.dina.PersonService;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/persons")
public class PersonController implements PersonService {
    private final PersonClient personClient;

    @Override
    @GetMapping
    public List<PersonDto> getAllPersons() {
        return personClient.getAllPersons();
    }

    @Override
    @PostMapping
    public void createNewPerson(@RequestBody PersonDto newPerson) {
        personClient.createNewPerson(newPerson);
    }

    @Override
    @GetMapping("/{id}")
    public PersonDto findPersonById(@PathVariable("id") Long id) {
        return personClient.findPersonById(id);
    }

    @Override
    @PutMapping("/{id}")
    public void replacePerson(@RequestBody PersonDto newPerson, @PathVariable("id") Long id) {
        personClient.replacePerson(newPerson, id);
    }

    @Override
    @DeleteMapping("/{id}")
    public void deletePersonById(@PathVariable("id") Long id) {
        personClient.deletePersonById(id);
    }
}
