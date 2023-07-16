package bartosz.szablewski.employee.service;

import bartosz.szablewski.employee.exception.DuplicatedEntityException;
import bartosz.szablewski.employee.exception.EntityNotFoundException;
import bartosz.szablewski.employee.model.Employee;
import bartosz.szablewski.employee.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(final EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee findById(final long employeeId) {
        return employeeRepository.findById(employeeId)
                .orElseThrow(() -> new EntityNotFoundException(employeeId));
    }

    @Transactional
    public Long createEmployee(final Employee employee) {

        if (employee.getEmployeeId() != null) {
            employeeRepository.findById(employee.getEmployeeId())
                    .orElseThrow(() -> new DuplicatedEntityException(employee.getEmployeeId()));
        }

        log.info("Created new employee correctly");
        return employeeRepository.save(employee).getEmployeeId();
    }

    @Transactional(readOnly=true)
    public List<Employee> getAllEmployee(final Double salary) {
        if (salary != null) {
            return employeeRepository.filter();
        }
        return employeeRepository.findAll();
    }

    public Employee updateEmployee(final Employee toUpdate, final Employee result) {
        toUpdate.setName(result.getName());
        log.info("updated employee with given id: {}", toUpdate.getEmployeeId());
        return toUpdate;
    }

    public void deleteEmployee(final long employeeId) {
        Employee toDelete = findById(employeeId);
        employeeRepository.delete(toDelete);
        log.info("deleted employee with given id: {}", employeeId);
    }
}
