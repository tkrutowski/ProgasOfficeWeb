package focik.net.progasoffice.tasks.gasconnection.domain.port.secondary;

import focik.net.progasoffice.tasks.gasconnection.domain.model.GasConnection;
import focik.net.progasoffice.tasks.gasconnection.infrastructure.dto.GasConnectionQueryDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface GasConnectionRepository {

    Optional<GasConnection> findById(Integer id);
    List<GasConnection> findAll();
}
