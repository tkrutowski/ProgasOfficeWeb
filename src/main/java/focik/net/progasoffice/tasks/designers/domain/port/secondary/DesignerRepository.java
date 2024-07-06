package focik.net.progasoffice.tasks.designers.domain.port.secondary;

import focik.net.progasoffice.share.ActiveStatus;
import focik.net.progasoffice.tasks.designers.domain.model.Designer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface DesignerRepository {

    Optional<Designer> findById(Integer id);

    List<Designer> findAllByStatus(ActiveStatus status);

    List<Designer> findAll();

}
