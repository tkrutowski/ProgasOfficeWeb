package focik.net.progasoffice.tasks.workrange.infrastructure.jpa;

import focik.net.progasoffice.tasks.common.domain.model.TaskType;
import focik.net.progasoffice.tasks.workrange.infrastructure.dto.WorkRangeConnectionDbDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WorkRangeConnectionDtoRepository extends JpaRepository<WorkRangeConnectionDbDto, Integer> {

    Optional<WorkRangeConnectionDbDto> findByIdTaskAndTaskType(Integer id, TaskType taskType);
}
