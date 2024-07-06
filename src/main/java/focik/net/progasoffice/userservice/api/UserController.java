package focik.net.progasoffice.userservice.api;

import focik.net.progasoffice.userservice.api.dto.UserDto;
import focik.net.progasoffice.userservice.domain.AppUser;
import focik.net.progasoffice.userservice.domain.HttpResponse;
import focik.net.progasoffice.userservice.domain.exceptions.EmailAlreadyExistsException;
import focik.net.progasoffice.userservice.domain.exceptions.UserAlreadyExistsException;
import focik.net.progasoffice.userservice.domain.exceptions.UserNotFoundException;
import focik.net.progasoffice.userservice.domain.port.primary.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

//@CrossOrigin(exposedHeaders = "Jwt-Token")
@Log4j2
@RequiredArgsConstructor
@RestController
@RequestMapping(path = { "/api/v1/user"})
//najpierw sprawdza czy jest jakiś exception handler w exceptionHandling
public class UserController {

    private final ModelMapper mapper;
    private final GetUserUseCase getUserUseCase;
    private final IAddNewUserUseCase addNewUserUseCase;
    private final IUpdateUserUseCase updateUserUseCase;
    private final IDeleteUserUseCase deleteUserUseCase;
    private final IChangePasswordUseCase changePasswordUseCase;

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN_READ_ALL','USER_READ')")
    ResponseEntity<AppUser> getUser(@PathVariable Long id){
        int i=0;
        log.info("USER-SERVICE: Try find user by id: = " + id);
        AppUser user = getUserUseCase.findUserById(id);
        log.info(user != null ? "USER-SERVICE: Found user by ID = " + id : "USER-SERVICE: Not found user by ID = " + id);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN_READ_ALL','USER_READ_ALL')")
    ResponseEntity<List<UserDto>> getUsers(){
        int i=0;
//        log.info("USER-SERVICE: Try find user by id: = " + id);
        List<AppUser> allUsers = getUserUseCase.getAllUsers();
//        log.info(user != null ? "USER-SERVICE: Found user by ID = " + id : "USER-SERVICE: Not found user by ID = " + id);
        List<UserDto> userDtos = allUsers.stream().map(user -> mapper.map(user, UserDto.class)).collect(Collectors.toList());
        return new ResponseEntity<>(userDtos, HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMIN_WRITE_ALL')")
    public ResponseEntity<AppUser> register(@RequestBody AppUser user) throws UserNotFoundException, UserAlreadyExistsException, EmailAlreadyExistsException {
        int i=0;
        AppUser newUser = addNewUserUseCase.addNewUser(user.getFirstName(), user.getLastName(), user.getUsername(), user.getPassword(),
                user.getEmail(), user.isEnabled(), user.isNotLocked(), user.getIdEmployee());
        return new ResponseEntity<>(newUser, CREATED);
    }

    @PutMapping("/update")
    @PreAuthorize("hasAnyAuthority('ADMIN_WRITE_ALL')")
    public ResponseEntity<AppUser> updateUser(@RequestBody AppUser user){
        AppUser updatedUser = updateUserUseCase.updateUser(user.getId(), user.getFirstName(),
                user.getLastName(), user.getUsername(), user.getEmail());
        return new ResponseEntity<>(updatedUser, OK);
    }

    @PutMapping("/update/active/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN_WRITE_ALL')")
    public ResponseEntity<HttpResponse> updateUserActive(@PathVariable Long id, @RequestParam("enabled") boolean isEnabled ) {
            updateUserUseCase.updateIsActive(id, isEnabled);
        return response(HttpStatus.OK, "Zaaktualizowano status użytkownika.");
    }

    @PutMapping("/update/lock/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN_WRITE_ALL')")
    public ResponseEntity<HttpResponse> updateUserLock(@PathVariable Long id, @RequestParam("lock") boolean isLock ) {
        updateUserUseCase.updateIsLock(id, isLock);
        return response(HttpStatus.OK, "Zaaktualizowano status użytkownika.");
    }

    @PutMapping("/changepass/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN_WRITE_ALL','USER_WRITE')")
    public ResponseEntity<HttpResponse> changePassword(@PathVariable Long id, @RequestParam("oldPass") String oldPass, @RequestParam("newPass") String newPass) {
        changePasswordUseCase.changePassword(id, oldPass, newPass);
        return response(HttpStatus.OK, "Hasło zmienione.");
    }


    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN_DELETE_ALL')")
    public ResponseEntity<HttpResponse> deleteUser(@PathVariable Long id){
        deleteUserUseCase.deleteUserById(id);
        return response(HttpStatus.NO_CONTENT, "Użytkownik usunięty.");
    }

    private ResponseEntity<HttpResponse> response(HttpStatus status, String message){
        HttpResponse body = new HttpResponse(status.value(), status, status.getReasonPhrase(), message);
        return new ResponseEntity<>(body, status);
    }
}
