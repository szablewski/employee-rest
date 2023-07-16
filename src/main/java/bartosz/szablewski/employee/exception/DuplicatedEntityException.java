package bartosz.szablewski.employee.exception;

public class DuplicatedEntityException extends RuntimeException{

    public DuplicatedEntityException(final Long employeeId){
        super(String.format("Entity with given id %s: already exist", employeeId));
    }
}
