package focik.net.progasoffice.tasks.workrange.infrastructure.jpa;

import focik.net.progasoffice.tasks.common.domain.model.TaskType;
import focik.net.progasoffice.tasks.workrange.infrastructure.dto.WorkRangeGasConnectionDbDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkRangeGasConnectionDtoRepository extends JpaRepository<WorkRangeGasConnectionDbDto, Integer> {

    List<WorkRangeGasConnectionDbDto> findAllByIdTaskAndTaskType(Integer id, TaskType taskType);
}
