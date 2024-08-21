package focik.net.progasoffice.tasks.plot.domain.port.secondary;

import focik.net.progasoffice.tasks.common.domain.model.TaskType;
import focik.net.progasoffice.tasks.plot.domain.model.Plot;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface PlotRepository {
    Optional<Plot> getById(int id);

    List<Plot> findByTask(int idTask, TaskType taskType);

    List<Plot> findAll();
}
