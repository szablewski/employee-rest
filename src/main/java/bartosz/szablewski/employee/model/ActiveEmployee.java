package bartosz.szablewski.employee.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@DiscriminatorValue("active")
@Setter
@Getter
@NoArgsConstructor
public class ActiveEmployee extends Employee{

    @NotNull(message = "Salary cannot be null")
    private Double salary;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Date employment cannot be null")
    private Date dateEmployment;
}
