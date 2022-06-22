package ru.dina;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class PersonInfoServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersonInfoServiceApplication.class, args);
    }

}
