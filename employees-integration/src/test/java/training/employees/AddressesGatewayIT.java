package training.employees;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import training.employees.employees.gateway.AddressesGateway;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureWireMock(port = 18082)
public class AddressesGatewayIT {

    @Autowired
    AddressesGateway addressesGateway;

    @Test
    void testGetAddressToEmployee() {
        String resource = "/api/addresses";

        stubFor(get(urlPathEqualTo("/api/addresses"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBody("""
                                {
                                   "city": "Acacías",
                                   "address": "0705 Ruskin Parkway"
                                }
                                """)));

        var address = addressesGateway.getAddressToEmployee("John Doe");

        verify(getRequestedFor(urlPathEqualTo(resource))
                .withQueryParam("name", equalTo("John Doe")));

        assertEquals("Acacías", address.getCity());
        assertEquals("0705 Ruskin Parkway", address.getAddress());

    }
}
