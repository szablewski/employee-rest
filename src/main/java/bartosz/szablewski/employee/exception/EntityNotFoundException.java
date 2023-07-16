package bartosz.szablewski.employee.exception;

public class EntityNotFoundException extends RuntimeException{

    public EntityNotFoundException(final Long employeeId){
        super(String.format("Not found employee with given id %s: ", employeeId));
    }

}
