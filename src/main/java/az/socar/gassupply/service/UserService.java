package az.socar.gassupply.service;

import az.socar.gassupply.data.dto.request.LoginRequestDto;
import az.socar.gassupply.data.dto.request.RegisterRequestDto;
import az.socar.gassupply.data.dto.request.ResetPasswordRequestDto;
import az.socar.gassupply.data.dto.response.LoginResponseDto;
import org.springframework.http.ResponseEntity;

public interface UserService {

    LoginResponseDto login(LoginRequestDto loginRequestDto);

    ResponseEntity<String> register(RegisterRequestDto registerRequestDto);

    void registerConfirm(String activationCode);

    void resendEmail(String email);

    void forgetPassword(String email);

    void resetPassword(ResetPasswordRequestDto requestDto);
}
