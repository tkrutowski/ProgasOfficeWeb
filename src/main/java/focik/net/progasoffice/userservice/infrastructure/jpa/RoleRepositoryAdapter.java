package focik.net.progasoffice.userservice.infrastructure.jpa;

import focik.net.progasoffice.userservice.domain.Role;
import focik.net.progasoffice.userservice.domain.port.secondary.IRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class RoleRepositoryAdapter implements IRoleRepository {
    private final IRoleDtoRepository roleDtoRepository;
    @Override
    public Role addRole(Role role) {
        return null;
    }

    @Override
    public List<Role> getAllRoles() {
        return roleDtoRepository.findAll();
    }

    @Override
    public Role getRoleById(Long id) {
        Optional<Role> byId = roleDtoRepository.findById(id);

        if(byId.isEmpty())
            return null;

        return byId.get();
    }
}
