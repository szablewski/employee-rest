package bartosz.szablewski.employee.controller;

import bartosz.szablewski.employee.model.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeeControllerTest {
    private static final String URL_PREFIX = "/api/v1/employees";

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void shouldResponseOkWhenGetAllEmployee() {

        //when
        ResponseEntity<List> responseEntity = restTemplate.getForEntity(URL_PREFIX, List.class);

        //then
        assertEquals(OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertFalse(responseEntity.getBody().isEmpty());
    }

    @Test
    public void shouldResponseCreatedWhenCreateNewEmployee() {

        //given
        HttpEntity<Employee> request = new HttpEntity<>(createEmployee());

        //when
        ResponseEntity<Void> responseEntity = restTemplate.postForEntity(URL_PREFIX, request, Void.class);

        //then
        assertEquals(CREATED, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getHeaders().getLocation());
    }

    private Employee createEmployee() {
        Employee employee = new Employee();
//        employee.setEmployeeId(1L);
        employee.setName("test");

        return employee;
    }


}
