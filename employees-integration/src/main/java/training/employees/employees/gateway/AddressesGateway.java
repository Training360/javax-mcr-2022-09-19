package training.employees.employees.gateway;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class AddressesGateway {

    public ExternalAddressDto getAddressToEmployee(String name) {
        return WebClient
                .create("http://localhost:8082")
                .get()
                .uri(builder -> builder.path("/api/addresses").queryParam("name", name).build())
                .exchangeToMono(response -> response.bodyToMono(ExternalAddressDto.class))
                .block();
    }
}
