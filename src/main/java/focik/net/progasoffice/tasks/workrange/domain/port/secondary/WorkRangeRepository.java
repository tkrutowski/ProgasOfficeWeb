package focik.net.progasoffice.tasks.workrange.domain.port.secondary;

import focik.net.progasoffice.tasks.common.domain.model.TaskType;
import focik.net.progasoffice.tasks.workrange.domain.model.WorkRangeConnection;
import focik.net.progasoffice.tasks.workrange.domain.model.WorkRangeGasConnection;
import focik.net.progasoffice.tasks.workrange.domain.model.WorkRangeGasStation;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface WorkRangeRepository {

    List<WorkRangeGasConnection> findWorkRangeGasConnectionsByTask(int idTask, TaskType taskType);

    List<WorkRangeGasStation> findWorkRangeGasStationsByTask(int idTask, TaskType taskType);

    Optional<WorkRangeConnection> findWorkRangeConnectionsByTask(Integer id, TaskType taskType);

}
