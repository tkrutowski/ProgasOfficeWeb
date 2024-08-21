package focik.net.progasoffice.tasks.gasconnection.domain.port.secondary;

import focik.net.progasoffice.tasks.common.domain.model.Stage;
import focik.net.progasoffice.tasks.gasconnection.domain.model.GasConnection;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface GasConnectionRepository {

    Optional<GasConnection> findById(Integer id);

    List<GasConnection> findAll();

    List<GasConnection> findAllByFinish(Boolean isFinished);

    void updateStage(Integer idTask, Stage stage);
}
