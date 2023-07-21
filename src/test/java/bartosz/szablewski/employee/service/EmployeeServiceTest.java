package bartosz.szablewski.employee.service;

import bartosz.szablewski.employee.model.Employee;
import bartosz.szablewski.employee.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@TestInstance(PER_CLASS)
@SpringBootTest
class EmployeeServiceTest {

    private EmployeeRepository employeeRepository;
    private EmployeeService employeeService;

    @BeforeAll
    public void init(){
        employeeRepository = mock(EmployeeRepository.class);
        employeeService = new EmployeeService(employeeRepository);
    }

    @Test
    public void shouldReturnNotEmptyEmployeeList() {

        //given
        long employeeId = 0L;
        Employee employee = new Employee();
        employee.setEmployeeId(employeeId);
        employee.setName("test");

        when(employeeRepository.findAll()).thenReturn(Arrays.asList(employee));

        //when
        List<Employee> employees = employeeService.getAllEmployee(null);

        //then
        assertNotNull(employees);
        assertFalse(employees.isEmpty());
    }
}
