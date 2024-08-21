package focik.net.progasoffice.tasks.workrange.infrastructure.jpa;

import focik.net.progasoffice.tasks.common.domain.model.TaskType;
import focik.net.progasoffice.tasks.workrange.domain.model.WorkRange;
import focik.net.progasoffice.tasks.workrange.domain.model.WorkRangeGasConnection;
import focik.net.progasoffice.tasks.workrange.domain.model.WorkRangeGasStation;
import focik.net.progasoffice.tasks.workrange.domain.port.secondary.WorkRangeRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class WorkRangeGasConnectionRepositoryAdapter implements WorkRangeRepository {

    private final WorkRangeGasConnectionDtoRepository workRangeGasConnectionDtoRepository;
    private final WorkRangeGasStationDtoRepository workRangeGasStationDtoRepository;
    private final ModelMapper modelMapper;


    @Override
    public List<WorkRangeGasConnection> findWorkRangeGasConnectionsByTask(int idTask, TaskType taskType) {
        return workRangeGasConnectionDtoRepository.findAllByIdTaskAndTaskType(idTask, taskType)
                .stream()
                .map(dbDto -> modelMapper.map(dbDto, WorkRangeGasConnection.class))
                .toList();
    }

    @Override
    public List<WorkRangeGasStation> findWorkRangeGasStationsByTask(int idTask, TaskType taskType) {
        return workRangeGasStationDtoRepository.findAllByIdTaskAndTaskType(idTask, taskType)
                .stream()
                .map(dbDto -> modelMapper.map(dbDto, WorkRangeGasStation.class))
                .toList();
    }
}
