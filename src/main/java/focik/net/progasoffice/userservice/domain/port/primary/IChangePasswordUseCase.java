package focik.net.progasoffice.userservice.domain.port.primary;

public interface IChangePasswordUseCase {

    void changePassword(Long id, String oldPassword, String newPassword);
}
