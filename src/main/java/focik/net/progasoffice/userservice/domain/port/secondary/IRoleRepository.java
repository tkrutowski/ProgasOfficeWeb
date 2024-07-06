package focik.net.progasoffice.userservice.domain.port.secondary;


import focik.net.progasoffice.userservice.domain.Role;

import java.util.List;

public interface IRoleRepository {

    Role addRole(Role role);
    List<Role> getAllRoles();
    Role getRoleById(Long id);
}
