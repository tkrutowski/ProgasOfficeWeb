package focik.net.progasoffice.userservice.domain;

import focik.net.progasoffice.userservice.domain.exceptions.SettingsNotFoundException;
import focik.net.progasoffice.userservice.domain.port.primary.GetSettingsUseCase;
import focik.net.progasoffice.userservice.domain.model.Settings;
import focik.net.progasoffice.userservice.domain.port.primary.GetUserUseCase;
import focik.net.progasoffice.userservice.domain.port.primary.SaveSettingsUseCase;
import focik.net.progasoffice.userservice.domain.utility.UserHelper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class UserFacade implements GetSettingsUseCase, SaveSettingsUseCase, GetUserUseCase {

    private final IUserService userService;
    private final RoleService roleService;
    private final SettingsService   settingsService;

    public AppUser registerUser(String firstName, String lastName, String username, String password,
                                String email, boolean enabled, boolean isNotLocked, int idEmployee) {
        return userService.addNewUser(firstName, lastName, username, password, email, enabled, isNotLocked, idEmployee);
    }

    @Override
    public AppUser findUserByUsername(String username) {
         return userService.findUserByUsername(username);
    }

    public AppUser updateUser(Long id, String firstName, String lastName, String username, String email) {
        return userService.updateUser(id, firstName, lastName, username, email);
    }

    public void deleteUser(Long id) {
        userService.deleteUser(id);
    }

    public void changePassword(Long id, String oldPassword, String newPassword) {
        userService.changePassword(id, oldPassword, newPassword);
    }

    @Override
    public AppUser findUserById(Long id) {
        return userService.findUserById(id);
    }

    @Override
    public List<AppUser> getAllUsers() {
        return userService.getUsers();
    }

    @Override
    public boolean isEmployee() {
        Object principal = UserHelper.getPrincipal();
        return false;
    }

    @Override
    public boolean isDesigner() {
        return false;
    }

    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }

    @Transactional
    public void addRoleToUser(Long idUser, Long idRole) {
        AppUser userWithNewRole = roleService.addRoleToUser(userService.findUserById(idUser), idRole);
        userService.saveUser(userWithNewRole);
    }

//    public Privilege findPrivilegeByName(String name){
//        return roleService.findPrivilegeByName(name);
//    }

    public void changePrivilegesInUserRole(Long idUser, Long idRole, Map<String, String> privilegeMap) {
        AppUser userById = userService.findUserById(idUser);
        boolean result = roleService.changePrivilegesInUserRole(userById, idRole, privilegeMap);

        if(result)
            userService.saveUser(userById);
    }

    public void deleteUsersRoleById(Long idUser, Long idRole) {
        AppUser userById = userService.findUserById(idUser);
        roleService.deleteRoleFromUser(userById, idRole);

       userService.saveUser(userById);
    }

    public Privilege getRoleDetails(Long idUser, Long idRole) {
        AppUser userById = userService.findUserById(idUser);
        return roleService.getRoleDetails(userById, idRole);
    }

    public void updateIsActive(Long id, boolean isActive) {
        userService.updateIsActive(id, isActive);
    }

    public void updateIsLock(Long id, boolean isLock) {
        userService.updateIsLock(id, isLock);
    }

    @Override
    public Settings getSettingsByUser(Long idUser) {
        try {
            return settingsService.getSettings(idUser);
        } catch (IOException e) {
            throw new SettingsNotFoundException(e.getMessage());
        }
    }

    @Override
    public Settings getUserSettings() {
        String userName = UserHelper.getUserName();
        AppUser user = findUserByUsername(userName);
        try {
            return settingsService.getSettings(user.getId());
        } catch (IOException e) {
            throw new SettingsNotFoundException(e.getMessage());
        }
    }

    @Override
    public Settings saveAll(Settings settings) {
        settingsService.saveSettings(settings);
        try {
            return settingsService.getSettings(settings.getUserId());
        } catch (IOException e) {
            throw new SettingsNotFoundException(e.getMessage());
        }
    }
}
