package bartosz.szablewski.employee.controller;

import bartosz.szablewski.employee.model.ActiveEmployee;
import bartosz.szablewski.employee.model.Employee;
import bartosz.szablewski.employee.service.ActiveEmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/active_employees")
public class ActiveEmployeeController {

    private final ActiveEmployeeService activeEmployeeService;

    public ActiveEmployeeController(ActiveEmployeeService activeEmployeeService) {
        this.activeEmployeeService = activeEmployeeService;
    }

    @PostMapping(consumes = {"application/json"})
    public ResponseEntity createActiveEmployee(@RequestBody ActiveEmployee activeEmployee) {
        activeEmployeeService.createActiveEmployee(activeEmployee);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/{employeeId}")
    public Employee updateEmployee(@PathVariable long employeeId, @RequestBody ActiveEmployee result) {
        ActiveEmployee toUpdate = activeEmployeeService.findActiveEmployeeById(employeeId);
        return new ResponseEntity<>(activeEmployeeService.updateEmployee(toUpdate, result), HttpStatus.OK).getBody();
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity deleteEmployee(@PathVariable final long employeeId) {
        activeEmployeeService.deleteActiveEmployee(employeeId);
        return new ResponseEntity(HttpStatus.OK);
    }
}
