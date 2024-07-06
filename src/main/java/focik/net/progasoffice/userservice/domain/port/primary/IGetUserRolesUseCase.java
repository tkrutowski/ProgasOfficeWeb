package focik.net.progasoffice.userservice.domain.port.primary;


import focik.net.progasoffice.userservice.domain.Privilege;
import focik.net.progasoffice.userservice.domain.Role;

import java.util.List;

public interface IGetUserRolesUseCase {
    List<Role> getUserRoles(Long idUser);

    List<Role> getRoles();


//    Privilege getRoleDetailsDto(Long idUser, Long idRole);

    Privilege getRoleDetails(Long idUser, Long idRole);
}
