package focik.net.progasoffice.userservice.domain.port.primary;


import focik.net.progasoffice.userservice.domain.Role;

public interface ISaveRoleUseCase {
    Role saveRole(Role role);
}
