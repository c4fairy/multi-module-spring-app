package ru.dina;

import org.springframework.stereotype.Component;

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

    @Override
    public PersonDto personDtoToPerson(Person person) {
        if (person == null)
        return null;

        PersonDto personDto = new PersonDto();
        personDto.setId(person.getId());
        personDto.setName(person.getName());
        personDto.setAdress(person.getAdress());
        return personDto;
    }
}
