package focik.net.progasoffice.userservice.domain.port.primary;


public interface IAddRoleToUserUseCase {
    void addRoleToUser(Long idUser, Long idRole);
}
