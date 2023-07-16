package bartosz.szablewski.employee.service;

import bartosz.szablewski.employee.exception.EntityNotFoundException;
import bartosz.szablewski.employee.model.ActiveEmployee;
import bartosz.szablewski.employee.model.Employee;
import bartosz.szablewski.employee.repository.ActiveEmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class ActiveEmployeeService {

    private final ActiveEmployeeRepository employeeRepository;

    public ActiveEmployeeService(ActiveEmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Transactional
    public ActiveEmployee createActiveEmployee(ActiveEmployee activeEmployee) {
        log.info("Created new active employee correctly");
        return employeeRepository.save(activeEmployee);
    }

    public ActiveEmployee findActiveEmployeeById(final long employeeId) {
        return employeeRepository.findById(employeeId)
                .orElseThrow(() -> new EntityNotFoundException(employeeId));
    }

    public Employee updateEmployee(final Employee toUpdate, final Employee result) {
        toUpdate.setName(result.getName());
        log.info("updated employee with given id: {}", toUpdate.getEmployeeId());
        return toUpdate;
    }

    public void deleteActiveEmployee(final long employeeId) {
        ActiveEmployee toDelete = findActiveEmployeeById(employeeId);
        employeeRepository.delete(toDelete);
        log.info("deleted employee with given id: {}", employeeId);
    }
}
