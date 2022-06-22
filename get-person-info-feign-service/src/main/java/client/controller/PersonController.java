package client.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.dina.dto.Person;
import ru.dina.feign.PersonFeignClient;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/persons")
public class PersonController {

    private final PersonFeignClient personFeignClient;

    @GetMapping
    List<Person> getAllPersons() {
        return personFeignClient.getAllPersons();
    }

    @PostMapping
    Person createNewPerson(@RequestBody Person newPerson) {
        return personFeignClient.createNewPerson(newPerson);
    }

    @GetMapping("/{id}")
    Person findPersonById(@PathVariable Long id) {
        return personFeignClient.findPersonById(id);
    }


    @PutMapping("/{id}")
    Person replacePerson(@RequestBody Person newPerson, @PathVariable Long id) {
        return personFeignClient.replacePerson(newPerson, id);
    }


    @DeleteMapping("/{id}")
    void deletePersonById(@PathVariable Long id) {
        personFeignClient.deletePersonById(id);
    }
}
