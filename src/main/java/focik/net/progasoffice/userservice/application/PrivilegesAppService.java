package focik.net.progasoffice.userservice.application;

import focik.net.progasoffice.userservice.domain.AppUser;
import focik.net.progasoffice.userservice.domain.Privilege;
import focik.net.progasoffice.userservice.domain.Role;
import focik.net.progasoffice.userservice.domain.UserFacade;
import focik.net.progasoffice.userservice.domain.port.primary.AddPrivilegeUseCase;
import focik.net.progasoffice.userservice.domain.port.primary.UpdatePrivilegeUseCase;
import focik.net.progasoffice.userservice.domain.port.primary.DeletePrivilegeUseCase;
import focik.net.progasoffice.userservice.domain.port.primary.GetPrivilegesUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@RequiredArgsConstructor
@Service
public class PrivilegesAppService implements GetPrivilegesUseCase, AddPrivilegeUseCase,
        UpdatePrivilegeUseCase, DeletePrivilegeUseCase {

    private final UserFacade userFacade;

    @Override
    public List<Privilege> getUserPrivileges(Long idUser) {
        AppUser user = userFacade.findUserById(idUser);
        return user.getPrivileges();
    }

    @Override
    public List<Role> getRoles() {
        return userFacade.getAllRoles();
    }

    @Override
    public List<Privilege> getPrivilegesByUser(Long idUser) {
        return List.of();
    }

    @Override
    public Privilege getRoleDetails(Long idUser, Long idRole) {
        return userFacade.getRoleDetails(idUser, idRole);
    }

    @Override
    public void addRoleToUser(Long idUser, Long idRole) {
       userFacade.addRoleToUser(idUser, idRole);
    }

    @Override
    public void updatePrivilegesInUserRole(Long idUser, Privilege privilege) {
        userFacade.changePrivilegesInUserRole(idUser, privilege);
    }

    @Override
    public void deleteUsersRoleById(Long id, Long idRole) {
        userFacade.deleteUsersRoleById(id, idRole);
    }
}
