package focik.net.progasoffice.userservice.domain.port.primary;

public interface IDeleteUsersRoleUseCase {
    void deleteUsersRoleById(Long id, Long idRole);
}
