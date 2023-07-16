package bartosz.szablewski.employee.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Set;

@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class Team {
    @Id
    private String name;

    @ManyToMany(mappedBy = "teams")
    private Set<Employee> employees;
}
