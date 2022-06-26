package ru.dina;

import org.springframework.stereotype.Component;
import ru.dina.dto.Person;
import ru.dina.dto.PersonDto;

@Component
public class PersonMapperImpl implements PersonMapper {
    @Override
    public Person personToPersonDto(PersonDto personDto) {
        if (personDto == null)
        return null;

        Person person = new Person();

        person.setId(personDto.getId());
        person.setName(personDto.getName());
        person.setAdress(personDto.getAdress());
        return person;
    }
}
