package focik.net.progasoffice.tasks.workrange.domain.port.primary;

import focik.net.progasoffice.tasks.common.domain.model.TaskType;
import focik.net.progasoffice.tasks.workrange.domain.model.WorkRangeGasConnection;
import focik.net.progasoffice.tasks.workrange.domain.model.WorkRangeGasStation;

import java.util.List;

public interface GetWorkRangeUseCase {

    List<WorkRangeGasConnection> getWorkRangeGasConnectionsByTask(int idTask, TaskType taskType);

    List<WorkRangeGasStation> getWorkRangeGasStationsByTask(int idTask, TaskType taskType);

}
