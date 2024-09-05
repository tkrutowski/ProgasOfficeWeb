package focik.net.progasoffice.tasks.finance.infrastructure.jpa;

import focik.net.progasoffice.tasks.common.domain.model.TaskType;
import focik.net.progasoffice.tasks.finance.infrastructure.dto.CostDbDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CostDtoRepository extends JpaRepository<CostDbDto, Integer> {
    List<CostDbDto> findAllByIdTaskAndTaskType(Integer id, TaskType taskType);
}
