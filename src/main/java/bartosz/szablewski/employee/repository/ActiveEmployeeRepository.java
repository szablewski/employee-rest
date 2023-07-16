package bartosz.szablewski.employee.repository;

import bartosz.szablewski.employee.model.ActiveEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActiveEmployeeRepository extends JpaRepository<ActiveEmployee, Long> {

    @Query("from ActiveEmployee")
    List<ActiveEmployee> getActiveEmployee();
}
