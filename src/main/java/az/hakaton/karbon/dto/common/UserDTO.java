package az.hakaton.karbon.dto.common;

import az.hakaton.karbon.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private String firstname;
    private String lastname;
    private String email;
    private String password;

    public UserDTO(User user) {
        this.firstname = user.getFirstname();
        this.lastname = user.getLastname();
        this.email = user.getEmail();
        this.password = user.getPassword();
    }

}
