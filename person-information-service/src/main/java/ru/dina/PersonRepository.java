package ru.dina;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dina.dto.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
