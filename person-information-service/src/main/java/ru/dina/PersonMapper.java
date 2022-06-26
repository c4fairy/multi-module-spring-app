package ru.dina;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(
        componentModel = "spring"
)
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);
    Person personToPersonDto(PersonDto personDto);
    PersonDto personDtoToPerson(Person person);
}

