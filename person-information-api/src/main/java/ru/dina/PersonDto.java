package ru.dina;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PersonDto {
    @JsonProperty("id")
    private long id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("adress")
    private String adress;

    public PersonDto(long l, String name, String address) {
    }

    public PersonDto() {
    }

}
