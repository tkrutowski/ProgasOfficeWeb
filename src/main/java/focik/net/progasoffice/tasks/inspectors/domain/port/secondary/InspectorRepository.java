package focik.net.progasoffice.tasks.inspectors.domain.port.secondary;

import focik.net.progasoffice.share.ActiveStatus;
import focik.net.progasoffice.tasks.designers.domain.model.Designer;
import focik.net.progasoffice.tasks.inspectors.domain.model.Inspector;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface InspectorRepository {

    Optional<Inspector> findById(Integer id);

    List<Inspector> findAllByStatus(ActiveStatus status);

    List<Inspector> findAll();

}
