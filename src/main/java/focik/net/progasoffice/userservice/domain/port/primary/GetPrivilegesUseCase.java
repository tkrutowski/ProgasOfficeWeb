package focik.net.progasoffice.userservice.domain.port.primary;


import focik.net.progasoffice.userservice.domain.Privilege;
import focik.net.progasoffice.userservice.domain.Role;

import java.util.List;

public interface GetPrivilegesUseCase {
    List<Privilege> getUserPrivileges(Long idUser);

    List<Role> getRoles();


    List<Privilege> getPrivilegesByUser(Long idUser);

    Privilege getRoleDetails(Long idUser, Long idRole);
}
