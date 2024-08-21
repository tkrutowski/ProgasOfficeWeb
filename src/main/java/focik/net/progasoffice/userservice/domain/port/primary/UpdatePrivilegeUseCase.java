package focik.net.progasoffice.userservice.domain.port.primary;

import focik.net.progasoffice.userservice.domain.Privilege;

public interface UpdatePrivilegeUseCase {
    void updatePrivilegesInUserRole(Long idUser, Privilege privilege);
}
