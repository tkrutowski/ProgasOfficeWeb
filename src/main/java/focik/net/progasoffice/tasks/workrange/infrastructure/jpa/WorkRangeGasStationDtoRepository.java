package focik.net.progasoffice.tasks.workrange.infrastructure.jpa;

import focik.net.progasoffice.tasks.common.domain.model.TaskType;
import focik.net.progasoffice.tasks.workrange.infrastructure.dto.WorkRangeGasConnectionDbDto;
import focik.net.progasoffice.tasks.workrange.infrastructure.dto.WorkRangeGasStationDbDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkRangeGasStationDtoRepository extends JpaRepository<WorkRangeGasStationDbDto, Integer> {

    List<WorkRangeGasStationDbDto> findAllByIdTaskAndTaskType(Integer id, TaskType taskType);
}
