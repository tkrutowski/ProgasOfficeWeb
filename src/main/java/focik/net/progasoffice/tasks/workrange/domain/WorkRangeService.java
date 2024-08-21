package focik.net.progasoffice.tasks.workrange.domain;

import focik.net.progasoffice.tasks.common.domain.model.TaskType;
import focik.net.progasoffice.tasks.workrange.domain.model.WorkRangeGasConnection;
import focik.net.progasoffice.tasks.workrange.domain.model.WorkRangeGasStation;
import focik.net.progasoffice.tasks.workrange.domain.port.secondary.WorkRangeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class WorkRangeService {
    private final WorkRangeRepository workRangeRepository;

    public List<WorkRangeGasConnection> getWorkRangeGasConnectionsByTask(int idTask, TaskType taskType) {
        return workRangeRepository.findWorkRangeGasConnectionsByTask(idTask, taskType);
    }

    public List<WorkRangeGasStation> getWorkRangeGasStationsByTask(int idTask, TaskType taskType) {
        return workRangeRepository.findWorkRangeGasStationsByTask(idTask, taskType);
    }
}
