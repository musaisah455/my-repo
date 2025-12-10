package my_apps.employee.model;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class EmployeeRequest {

    @NotBlank @Size(min = 2, max = 50)
    private String firstName;

    @NotBlank @Size(min = 2, max = 50)
    private String lastName;

    @NotBlank @Email
    private String email;

    private String department;

    @NotBlank @Size(min = 2, max = 100)
    private String position;

    @DecimalMin(value = "0.0", inclusive = false)
    private Double salary;
}