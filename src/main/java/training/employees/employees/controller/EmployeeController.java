package training.employees.employees.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import training.employees.employees.dto.CreateEmployeeCommand;
import training.employees.employees.dto.EmployeeDetailsDto;
import training.employees.employees.dto.EmployeeDto;
import training.employees.employees.dto.UpdateEmployeeCommand;
import training.employees.employees.service.EmployeesService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
@Slf4j
public class EmployeeController {

    private EmployeesService service;

    @GetMapping
    // @ResponseBody - nem kell kitenni, mert a @RestController minden metódusra
    // automatikusan ráteszi
    public List<EmployeeDto> listEmployees(@RequestParam("prefix") Optional<String> prefix) {
        log.info("List employees");
        log.debug("List employees with prefix {}", prefix);
        return service.listEmployees(prefix);
    }

    @GetMapping("{id}")
    public EmployeeDetailsDto findEmployeeById(@PathVariable("id") long id) {
        return service.findEmployeeById(id);
    }

    @PostMapping
    @Operation(summary = "Create a new employee", description = "Create a new employee with name and year of birth")
//    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<EmployeeDetailsDto> createEmployee(@Valid @RequestBody CreateEmployeeCommand command,
                                                             UriComponentsBuilder uri) {
        var employee = service.createEmployee(command);
        return ResponseEntity
                .created(uri.path("/api/employees/{id}").buildAndExpand(employee.getId()).toUri())
                .body(employee);
    }

    @PutMapping("{id}")
    public EmployeeDetailsDto updateEmployee(@PathVariable("id") long id,
                                             @RequestBody UpdateEmployeeCommand command) {
        return service.updateEmployee(id, command);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEmployee(@PathVariable("id") long id) {
        service.deleteEmployee(id);
    }

}
