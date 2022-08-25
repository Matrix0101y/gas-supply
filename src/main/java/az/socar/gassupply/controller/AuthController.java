package az.socar.gassupply.controller;

import az.socar.gassupply.data.dto.request.LoginRequestDto;
import az.socar.gassupply.data.dto.request.RegisterRequestDto;
import az.socar.gassupply.data.dto.request.ResetPasswordRequestDto;
import az.socar.gassupply.data.dto.response.LoginResponseDto;
import az.socar.gassupply.security.jwt.JwtUtil;
import az.socar.gassupply.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static az.socar.gassupply.enums.MessageCase.*;


@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;


    @PostMapping(value = "login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequestDto) {
        return ResponseEntity.ok(userService.login(loginRequestDto));
    }


    @PostMapping(value = "register")
    public ResponseEntity<String> register(@RequestBody RegisterRequestDto registerRequestDto) {
        return userService.register(registerRequestDto);
    }

    @GetMapping(value = "register-confirm")
    public ResponseEntity<String> registerConfirm(@RequestParam(value = "activationcode") String activationCode) {
        userService.registerConfirm(activationCode);
        return new ResponseEntity<>(REGISTRATION_SUCCESSFULLY_CONFIRMED.getMessage(), HttpStatus.OK);
    }

    @GetMapping(value = "resend")
    public ResponseEntity<String> resendEmail(@RequestParam(value = "email")String email){
        userService.resendEmail(email);
        return ResponseEntity.ok(RESEND_EMAIL_SUCCESSFULLY_SENT.getMessage());
    }

    @GetMapping(value = "forget-password")
    public ResponseEntity<String> forgetPassword(@RequestParam(value = "email")String email){
        userService.forgetPassword(email);
        return ResponseEntity.ok(PASSWORD_CONFIRMATION_LINK.getMessage());
    }

    @PutMapping(value = "reset-password")
    public ResponseEntity<String> resetPassword(@RequestBody ResetPasswordRequestDto requestDto){
        userService.resetPassword(requestDto);
        return ResponseEntity.ok(PASSWORD_SUCCESFULLY_CHANGED.getMessage());
    }
}
