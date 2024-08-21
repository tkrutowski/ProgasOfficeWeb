package focik.net.progasoffice.userservice.domain.port.primary;


public interface AddPrivilegeUseCase {
    void addRoleToUser(Long idUser, Long idRole);
}
