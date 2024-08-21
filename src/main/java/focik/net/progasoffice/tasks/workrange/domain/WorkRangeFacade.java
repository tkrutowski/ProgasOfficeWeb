package focik.net.progasoffice.tasks.workrange.domain;

import focik.net.progasoffice.tasks.common.domain.model.TaskType;
import focik.net.progasoffice.tasks.workrange.domain.model.WorkRangeGasConnection;
import focik.net.progasoffice.tasks.workrange.domain.model.WorkRangeGasStation;
import focik.net.progasoffice.tasks.workrange.domain.port.primary.GetWorkRangeUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class WorkRangeFacade implements GetWorkRangeUseCase {

    private final WorkRangeService workRangeService;

    @Override
    public List<WorkRangeGasConnection> getWorkRangeGasConnectionsByTask(int idTask, TaskType taskType) {
        return workRangeService.getWorkRangeGasConnectionsByTask(idTask, taskType);
    }

    @Override
    public List<WorkRangeGasStation> getWorkRangeGasStationsByTask(int idTask, TaskType taskType) {
        return workRangeService.getWorkRangeGasStationsByTask(idTask, taskType);
    }

}
