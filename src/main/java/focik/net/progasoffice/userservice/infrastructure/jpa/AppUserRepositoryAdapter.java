package focik.net.progasoffice.userservice.infrastructure.jpa;


import focik.net.progasoffice.userservice.domain.AppUser;
import focik.net.progasoffice.userservice.domain.port.secondary.IAppUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AppUserRepositoryAdapter implements IAppUserRepository {

    private final IUserDtoRepository userDtoRepository;

    @Override
    public AppUser addUser(AppUser user) {
        return null;
    }

    @Override
    public AppUser findUserByUsername(String username) {
        Optional<AppUser> byUserName = userDtoRepository.findByUsername(username);

        return byUserName.orElse(null);

    }

    @Override
    public AppUser save(AppUser user) {
        return userDtoRepository.save(user);
    }

    @Override
    public List<AppUser> findAll() {
        return userDtoRepository.findAll();
    }

    @Override
    public AppUser findUserByEmail(String email) {
        Optional<AppUser> byEmail = userDtoRepository.findByEmail(email);

        return byEmail.orElse(null);

    }

    @Override
    public AppUser findUserById(Long id) {
        int i=0;
        Optional<AppUser> byId = userDtoRepository.findById(id);
        return byId.orElse(null);

    }

    @Override
    public void deleteUser(Long id) {
        userDtoRepository.deleteById(id);
    }
}
