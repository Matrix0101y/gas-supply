package az.socar.gassupply.data.dto.request;

import lombok.Data;

@Data
public class LoginRequestDto {

    private String usernameOrEmail;

    private String password;

}
