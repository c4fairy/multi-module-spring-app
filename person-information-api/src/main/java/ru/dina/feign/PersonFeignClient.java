package ru.dina.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import ru.dina.dto.Person;

import java.util.List;

@FeignClient(name = "person-service", url = "${url.client:http://localhost:8080//persons/}")
public interface PersonFeignClient {
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
