package focik.net.progasoffice.userservice.infrastructure.jpa;


import focik.net.progasoffice.userservice.domain.Privilege;
import focik.net.progasoffice.userservice.domain.port.secondary.IPrivilegeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PrivilegeRepositoryAdapter implements IPrivilegeRepository {
    private final IPrivilegeDtoRepository privilegeDtoRepository;


    @Override
    public Privilege getPrivilegeById(Long id) {
        Optional<Privilege> byId = privilegeDtoRepository.findById(id);

        if(byId.isEmpty())
            return null;

        return byId.get();
    }

    @Override
    public Privilege save(Privilege privilege) {
        return privilegeDtoRepository.save(privilege);
    }
}
