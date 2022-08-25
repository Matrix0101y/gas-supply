package az.socar.gassupply.data.dto.response;

import lombok.Data;

@Data
public class LoginResponseDto {
    private String token;
    private String tokeType="Bearer";

    public LoginResponseDto(String token) {
        this.token = token;
    }
}
