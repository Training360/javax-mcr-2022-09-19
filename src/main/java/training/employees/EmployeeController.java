package training.employees;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    public EmployeeDetailsDto createEmployee(@RequestBody CreateEmployeeCommand command) {
        return service.createEmployee(command);
    }

    @PutMapping("{id}")
    public EmployeeDetailsDto updateEmployee(@PathVariable("id") long id,
                                             @RequestBody UpdateEmployeeCommand command) {
        return service.updateEmployee(id, command);
    }
}
