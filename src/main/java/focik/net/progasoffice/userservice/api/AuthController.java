package focik.net.progasoffice.userservice.api;

import focik.net.progasoffice.userservice.api.dto.AuthenticationRequest;
import focik.net.progasoffice.userservice.api.dto.AuthenticationResponse;
import focik.net.progasoffice.userservice.api.dto.RefreshRequest;
import focik.net.progasoffice.userservice.application.AuthenticationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

//@CrossOrigin
@Log4j2
@RequiredArgsConstructor
@RestController
@RequestMapping(path = {"/api/v1/auth"})
public class AuthController {

    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest authenticationRequest) {

        return ResponseEntity.ok(authenticationService.authenticate(authenticationRequest));
    }

    @PostMapping("/refresh")
    public ResponseEntity<AuthenticationResponse> refreshToken(@RequestBody RefreshRequest refreshRequest) throws IOException {
        AuthenticationResponse refreshedToken = authenticationService.refreshToken(refreshRequest);
            return ResponseEntity.ok(refreshedToken);
    }
}
