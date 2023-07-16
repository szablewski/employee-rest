package bartosz.szablewski.employee.controller;

import bartosz.szablewski.employee.model.Employee;
import bartosz.szablewski.employee.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping(consumes = {"application/json"})
    public ResponseEntity createEmployee(@Valid @RequestBody Employee employee) {
        Long employeeId = employeeService.createEmployee(employee);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(employeeId).toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping
    public List<Employee> getAllEmployee(@RequestParam(required = false) final Double salary) {
        List<Employee> result = employeeService.getAllEmployee(salary);
        return new ResponseEntity<>(result, HttpStatus.OK).getBody();
    }

    @PutMapping("/{employeeId}")
    public Employee updateEmployee(@PathVariable long employeeId, @RequestBody Employee result) {
        Employee toUpdate = employeeService.findById(employeeId);
        return new ResponseEntity<>(employeeService.updateEmployee(toUpdate, result), HttpStatus.OK).getBody();
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity deleteEmployee(@PathVariable final long employeeId) {
        employeeService.deleteEmployee(employeeId);
        return new ResponseEntity(HttpStatus.OK);
    }
}
