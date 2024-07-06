package focik.net.progasoffice.userservice.domain.port.secondary;


import focik.net.progasoffice.userservice.domain.Privilege;

public interface IPrivilegeRepository {

//    Role addRole(Role role);
//    List<Role> getAllRoles();
//     Privilege getPrivilegeByName(String name);
     Privilege getPrivilegeById(Long id);

     Privilege save(Privilege privilege);
}
