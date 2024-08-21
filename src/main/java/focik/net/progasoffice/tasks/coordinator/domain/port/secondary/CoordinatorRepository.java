package focik.net.progasoffice.tasks.coordinator.domain.port.secondary;

import focik.net.progasoffice.share.ActiveStatus;
import focik.net.progasoffice.tasks.coordinator.domain.model.Coordinator;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface CoordinatorRepository {

    Optional<Coordinator> findById(Integer id);

    List<Coordinator> findAllByStatus(ActiveStatus status);

    List<Coordinator> findAll();

}
