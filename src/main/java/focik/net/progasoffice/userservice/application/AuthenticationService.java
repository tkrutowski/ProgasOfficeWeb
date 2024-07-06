package focik.net.progasoffice.userservice.application;

import focik.net.progasoffice.userservice.api.dto.AuthenticationRequest;
import focik.net.progasoffice.userservice.api.dto.AuthenticationResponse;
import focik.net.progasoffice.userservice.api.dto.RefreshRequest;
import focik.net.progasoffice.userservice.domain.AppUser;
import focik.net.progasoffice.userservice.domain.JwtService;
import focik.net.progasoffice.userservice.domain.exceptions.TokenExpiredException;
import focik.net.progasoffice.userservice.domain.port.primary.GetUserUseCase;
import focik.net.progasoffice.userservice.domain.port.secondary.IAppUserRepository;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final GetUserUseCase getUserUseCase;
    private final JwtService jwtService;
    private final IAppUserRepository userRepository;

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        AppUser loginUser = getUserUseCase.findUserByUsername(request.getUsername());
        var jwtToken = jwtService.generateToken(loginUser);
        var refreshToken = jwtService.generateRefreshToken(loginUser);
//        revokeAllUserTokens(user);
//        saveUserToken(user, jwtToken);
        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .build();
    }

    public AuthenticationResponse refreshToken(RefreshRequest request) {
//        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
//        final String refreshToken;
//        final String username;
//        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
//            return null;
//        }
        try {

            String refreshToken = request.getRefreshToken();
            String username = jwtService.extractUsername(refreshToken);
            if (username != null) {
                var user = userRepository.findUserByUsername(username);
                if (jwtService.isTokenValid(refreshToken, user)) {
                    var accessToken = jwtService.generateToken(user);
                    return AuthenticationResponse.builder()
                            .accessToken(accessToken)
                            .refreshToken(refreshToken)
                            .build();
                }
            }
        } catch (ExpiredJwtException e) {
            throw new TokenExpiredException("REFRESH TOKEN EXPIRED");

        }
        return null;
    }
}
