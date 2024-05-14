package ru.bebriki.sstusecurity.auth;

import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.bebriki.sstusecurity.exceptions.UserNotFoundException;

@CrossOrigin
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<?> register(
            @RequestBody @Valid RegistrationRequest request
    ) throws MessagingException, UserNotFoundException {
        service.register(request);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/activate-account")
    public boolean confirm(
            @RequestParam String token
    ) throws MessagingException, UserNotFoundException {
        return service.activateAccount(token);
    }

}
