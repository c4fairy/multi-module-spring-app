package client;

import org.springframework.cloud.openfeign.FeignClient;
import ru.dina.PersonService;

@FeignClient(name = "person-service", url = "${url.client:http://localhost:8080}", path = "/persons")
public interface PersonClient extends PersonService {
}
