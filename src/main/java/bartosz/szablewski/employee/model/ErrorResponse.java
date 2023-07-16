package bartosz.szablewski.employee.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.List;

@Setter
@Getter
public class ErrorResponse {

    private HttpStatus status;
    private String message;
    private List<String> errors;

    public ErrorResponse() {
        super();
    }

    public ErrorResponse(final HttpStatus status, final String message, final List<String> errors) {
        super();
        this.status = status;
        this.message = message;
        this.errors = errors;
    }

    public ErrorResponse(final HttpStatus status, final String message, final String error) {
        super();
        this.status = status;
        this.message = message;
        errors = Arrays.asList(error);
    }
}
