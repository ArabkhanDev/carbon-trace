package az.hakaton.karbon.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
public class RegisterRequest {

    @NotBlank(message = "First name is required.")
    @Size(min = 2, max = 50, message = "First name should be between 2 and 50 characters.")
    private String firstname;

    @NotBlank(message = "Last name is required.")
    @Size(min = 2, max = 50, message = "Last name should be between 2 and 50 characters.")
    private String lastname;

    @NotBlank(message = "Email is required.")
    @Email(message = "Please provide a valid email address.")
    private String email;

    @NotBlank(message = "Password is required.")
    @Size(min = 10, message = "Password should be at least 10 characters long.")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z]).*$", message = "Password must contain at least one lowercase letter and one uppercase letter.")
    private String password;
}
