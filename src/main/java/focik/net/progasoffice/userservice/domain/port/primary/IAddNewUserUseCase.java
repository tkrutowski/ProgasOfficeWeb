package focik.net.progasoffice.userservice.domain.port.primary;


import focik.net.progasoffice.userservice.domain.AppUser;

public interface IAddNewUserUseCase {

    AppUser addNewUser(String firstName, String lastName, String username, String password, String email, boolean enabled,
                       boolean isNotLocked, int idEmployee);
}
