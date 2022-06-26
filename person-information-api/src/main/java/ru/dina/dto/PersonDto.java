package ru.dina.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Objects;
@Data
//object ready for storage in a JPA-based data store
    public class PersonDto {
    @JsonProperty("id")
    private long id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("adress")
    private String adress;

    public PersonDto(long l, String name, String some_address1) {
    }

    public PersonDto() {}

}
