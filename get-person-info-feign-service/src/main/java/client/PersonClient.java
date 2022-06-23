package client;

import org.springframework.cloud.openfeign.FeignClient;
import ru.dina.dto.PersonService;

@FeignClient(name = "person-service", url = "${url.client:http://localhost:8080//persons/}") //+path вместо url (хост и порт через еврику/конфиг)
public interface PersonClient extends PersonService {
}
