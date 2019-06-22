package example.com.dbauth.auth;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class UserDataForm {
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
    @NotEmpty
    private String passwordRepeated;
}
