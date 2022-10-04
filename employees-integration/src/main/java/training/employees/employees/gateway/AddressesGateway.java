package training.employees.employees.gateway;

import lombok.AllArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;
import reactor.netty.resources.ConnectionProvider;

import java.time.Duration;

@Gateway
@EnableConfigurationProperties(GatewayProperties.class)
@AllArgsConstructor
public class AddressesGateway {

    private GatewayProperties gatewayProperties;

    public ExternalAddressDto getAddressToEmployee(String name) {
        var connectionProviderName = "myConnectionProvider";
        HttpClient httpClient = HttpClient.create(
                ConnectionProvider.create(connectionProviderName, gatewayProperties.getThreads()));

        var webClient = WebClient.builder().clientConnector(
                new ReactorClientHttpConnector(httpClient)
        )
                .baseUrl(gatewayProperties.getUrl())
                .build();

        return webClient
                .get()
                .uri(builder -> builder.path("/api/addresses").queryParam("name", name).build())
                .exchangeToMono(response -> response.bodyToMono(ExternalAddressDto.class))
                .timeout(Duration.parse(gatewayProperties.getTimeout()))
                .onErrorReturn(new ExternalAddressDto("not", "found"))
                .block();
    }
}
