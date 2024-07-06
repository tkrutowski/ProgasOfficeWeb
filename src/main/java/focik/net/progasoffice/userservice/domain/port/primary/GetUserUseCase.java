package focik.net.progasoffice.userservice.domain.port.primary;


import focik.net.progasoffice.userservice.domain.AppUser;

import java.util.List;

public interface GetUserUseCase {
    AppUser findUserByUsername(String username);

    AppUser findUserById(Long id);

    List<AppUser> getAllUsers();

    boolean isEmployee();

    boolean isDesigner();
}
