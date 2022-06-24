package ru.dina;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class PersonServiceApp {

    public static void main(String[] args) {
        SpringApplication.run(PersonServiceApp.class, args);
    }

}
