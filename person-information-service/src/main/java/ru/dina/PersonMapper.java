package ru.dina;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.dina.dto.Person;
import ru.dina.dto.PersonDto;

@Mapper(
        componentModel = "spring"
)
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);
    Person personToPersonDto(PersonDto person);
}

