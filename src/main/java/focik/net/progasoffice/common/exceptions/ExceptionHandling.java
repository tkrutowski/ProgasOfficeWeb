package focik.net.progasoffice.common.exceptions;

import focik.net.progasoffice.userservice.domain.exceptions.*;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.persistence.NoResultException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.IOException;

import static org.springframework.http.HttpStatus.*;

@Slf4j
@RestControllerAdvice
public class ExceptionHandling extends ResponseEntityExceptionHandler {
    public static final  String METHOD_IS_NOT_ALLOWED = "This request method is not allowed on this endpoint. Please send a '%s' request.";
    public static final  String INTERNAL_SERVER_ERROR_MSG = "An error occurred while processing the request.";
    public static final  String ERROR_PROCESSING_FILE = "Error occurred while processing file.";
    public static final  String NOT_ENOUGH_PERMISSION = "Nie masz wystarczających uprawnień.";
    public final String ACCOUNT_LOCKED = "Twoje konto zostało zablokowane. Skontaktuj się z administratorm.";
    public final String INCORRECT_CREDENTIALS = "Niepoprawne dane logowania. Spróbuj ponownie.";
    public final String ACCOUNT_DISABLED = "Twoje konto zostało wyłączone. Jeśli to błąd skontaktuj się z administratorem.";
    public static final  String ERROR_PATH = "/error";


    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<HttpResponse> accessDeniedException() {
        return createHttpResponse(FORBIDDEN, NOT_ENOUGH_PERMISSION);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<HttpResponse> badCredentials() {
        return createHttpResponse(UNAUTHORIZED, INCORRECT_CREDENTIALS);
    }

    @ExceptionHandler(ObjectAlreadyExistException.class)
    public ResponseEntity<HttpResponse> alreadyExistException(ObjectAlreadyExistException exception) {
        return createHttpResponse(CONFLICT, exception.getMessage());
    }

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<HttpResponse> notFoundException(ObjectNotFoundException exception) {
        return createHttpResponse(NOT_FOUND, exception.getMessage());
    }

    @ExceptionHandler(ObjectCanNotBeDeletedException.class)
    public ResponseEntity<HttpResponse> canNotBeDeletedException(ObjectCanNotBeDeletedException exception) {
        return createHttpResponse(LOCKED, exception.getMessage());
    }

    @ExceptionHandler(ObjectNotValidException.class)
    public ResponseEntity<HttpResponse> notValidException(ObjectNotValidException exception) {
        return createHttpResponse(NOT_FOUND, exception.getMessage());
    }

//    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
//    public ResponseEntity<HttpResponse> methodNotSupportedException(HttpRequestMethodNotSupportedException exception) {
//        HttpMethod supportedMethod = Objects.requireNonNull(exception.getSupportedHttpMethods()).iterator().next();
//        return createHttpResponse(METHOD_NOT_ALLOWED, String.format(METHOD_IS_NOT_ALLOWED, supportedMethod));
//    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<HttpResponse> internalServerErrorException(Exception exception) {
        log.error(exception.getMessage());
        return createHttpResponse(INTERNAL_SERVER_ERROR, INTERNAL_SERVER_ERROR_MSG);
    }
    @ExceptionHandler(ExpiredJwtException.class)
    public ResponseEntity<HttpResponse> tokenExpired(ExpiredJwtException exception) {
        log.error(exception.getMessage());
        return createHttpResponse(UNAUTHORIZED, "Token expired");
    }

    @ExceptionHandler(TokenExpiredException.class)
    public ResponseEntity<HttpResponse> tokenExpired(TokenExpiredException exception) {
        log.error(exception.getMessage());
        return createHttpResponse(UNAUTHORIZED, "REFRESH TOKEN EXPIRED");
    }

    @ExceptionHandler(NoResultException.class)
    public ResponseEntity<HttpResponse> notFoundException(NoResultException exception) {
        log.error(exception.getMessage());
        return createHttpResponse(NOT_FOUND, exception.getMessage());
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity<HttpResponse> iOException(IOException exception) {
        log.error(exception.getMessage());
        return createHttpResponse(INTERNAL_SERVER_ERROR, ERROR_PROCESSING_FILE);
    }

    @RequestMapping(ERROR_PATH)
    public ResponseEntity<HttpResponse> notFound404(Exception exception) {
        return createHttpResponse(NOT_FOUND, "There is no mapping for this URL");
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<HttpResponse> runtimeException(RuntimeException exception) {
    log.error(exception.getMessage());
        return createHttpResponse(INTERNAL_SERVER_ERROR, ERROR_PROCESSING_FILE);
    }


    private ResponseEntity<HttpResponse> createHttpResponse(HttpStatus httpStatus, String message) {
        HttpResponse httpResponse = new HttpResponse(httpStatus.value(), httpStatus,
                httpStatus.getReasonPhrase().toUpperCase(), message);

        return new ResponseEntity<>(httpResponse, httpStatus);
    }

//    @ExceptionHandler(DisabledException.class)
//    public ResponseEntity<HttpResponse> accountDisabledException(DisabledException e) {//można przekazać Exception
//        return createHttpResponse(HttpStatus.BAD_REQUEST, ACCOUNT_DISABLED);
//    }
//
//
//    @ExceptionHandler(BadCredentialsException.class)
//    public ResponseEntity<HttpResponse> badCredentialsException() {
//        return createHttpResponse(BAD_REQUEST, INCORRECT_CREDENTIALS);
//    }
//
//
//
//    @ExceptionHandler(LockedException.class)
//    public ResponseEntity<HttpResponse> lockedException() {
//        return createHttpResponse(UNAUTHORIZED, ACCOUNT_LOCKED);
//    }

//    @ExceptionHandler(TokenExpiredException.class)
//    public ResponseEntity<HttpResponse> tokenExpiredException(TokenExpiredException exception) {
//        return createHttpResponse(UNAUTHORIZED, exception.getMessage());
//    }

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<HttpResponse> emailExistException(EmailAlreadyExistsException exception) {
        return createHttpResponse(BAD_REQUEST, exception.getMessage());
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<HttpResponse> usernameExistException(UserAlreadyExistsException exception) {
        return createHttpResponse(BAD_REQUEST, exception.getMessage());
    }

    @ExceptionHandler(EmailNotFoundException.class)
    public ResponseEntity<HttpResponse> emailNotFoundException(EmailNotFoundException exception) {
        return createHttpResponse(BAD_REQUEST, exception.getMessage());
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<HttpResponse> userNotFoundException(UserNotFoundException exception) {
        return createHttpResponse(BAD_REQUEST, exception.getMessage());
    }

    @ExceptionHandler(PrivilegeNotFoundException.class)
    public ResponseEntity<HttpResponse> privilegeNotFoundException(PrivilegeNotFoundException exception) {
        return createHttpResponse(BAD_REQUEST, exception.getMessage());
    }

    @ExceptionHandler(PasswordNotFoundException.class)
    public ResponseEntity<HttpResponse> passwordNotFoundException(PasswordNotFoundException exception) {
        return createHttpResponse(BAD_REQUEST, exception.getMessage());
    }



    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<HttpResponse> authenticationException(AuthenticationException exception) {
        log.error(exception.getMessage());
        return createHttpResponse(UNAUTHORIZED, exception.getMessage());
    }











    public String getErrorPath() {
        return ERROR_PATH;
    }
}
