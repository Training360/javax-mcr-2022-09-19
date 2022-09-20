package training.employees;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {

    private EmployeesService service;

    @GetMapping
    // @ResponseBody - nem kell kitenni, mert a @RestController minden metódusra
    // automatikusan ráteszi
    public List<EmployeeDto> listEmployees(@RequestParam("prefix") Optional<String> prefix) {
        return service.listEmployees(prefix);
    }

    @GetMapping("{id}")
    public EmployeeDetailsDto findEmployeeById(@PathVariable("id") long id) {
        return service.findEmployeeById(id);
    }

    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<EmployeeDetailsDto> createEmployee(@RequestBody CreateEmployeeCommand command,
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
    public void deleteEmployee(@PathVariable("id") long id) {
        service.deleteEmployee(id);
    }

}
