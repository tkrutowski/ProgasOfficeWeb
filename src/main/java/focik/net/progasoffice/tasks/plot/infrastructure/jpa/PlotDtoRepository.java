package focik.net.progasoffice.tasks.plot.infrastructure.jpa;

import focik.net.progasoffice.tasks.common.domain.model.TaskType;
import focik.net.progasoffice.tasks.plot.infrastructure.dto.PlotDbDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PlotDtoRepository extends JpaRepository<PlotDbDto, Integer> {

    List<PlotDbDto> findAllByIdTaskAndTaskType (Integer id, TaskType taskType);
}
