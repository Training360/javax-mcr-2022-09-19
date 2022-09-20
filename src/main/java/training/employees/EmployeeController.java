package training.employees;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {

    private EmployeesService service;

    @GetMapping
    // @ResponseBody - nem kell kitenni, mert a @RestController minden metódusra
    // automatikusan ráteszi
    public List<EmployeeDto> listEmployees() {
        return service.listEmployees();
    }

    @GetMapping("{id}")
    public EmployeeDetailsDto findEmployeeById(@PathVariable("id") long id) {
        return service.findEmployeeById(id);
    }
}
