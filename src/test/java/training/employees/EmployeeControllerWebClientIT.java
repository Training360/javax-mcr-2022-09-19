package training.employees;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jmx.export.naming.IdentityNamingStrategy;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EmployeeControllerWebClientIT {

    @Autowired
    WebTestClient webClient;

//    @Autowired
//    EmployeesRepository repository;

//    @BeforeEach
//    void deleteAll() {
//        repository.deleteAll();
//    }

    @Test
    void testCreateEmployee() {
        var result = webClient
                .post()
                .uri("/api/employees")
                .bodyValue(new CreateEmployeeCommand("Amber Doe", 1970))
                .exchange()
                .expectStatus().isCreated()
                .expectBody(EmployeeDetailsDto.class).value(e -> assertEquals("Amber Doe", e.getName()))
                .returnResult().getResponseBody();
        ;

        long id = result.getId();

        webClient
                .get()
                .uri("/api/employees")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(EmployeeDto.class)
                .value(employees -> {
                    System.out.println(employees);
                    assertTrue(employees.stream()
                        .anyMatch(e -> e.getName().equals("Amber Doe")));});

        webClient
                .get()
                .uri("/api/employees/{id}", id)
                .exchange()
                .expectBody(EmployeeDetailsDto.class)
                .value(e -> assertEquals("Amber Doe", e.getName()));
    }

    @Test
    void testNotFound() {
        webClient
                .get()
                .uri("/api/employees/{id}", Integer.MAX_VALUE)
                .exchange()
                .expectStatus().isNotFound();
    }
}
