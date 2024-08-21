package focik.net.progasoffice.tasks.plot.domain.port.primary;

import focik.net.progasoffice.tasks.common.domain.model.TaskType;
import focik.net.progasoffice.tasks.plot.domain.model.Plot;

import java.util.List;

public interface GetPlotUseCase {
    Plot getById(int id);

    List<Plot> getByTask(int idTask, TaskType taskType);

    List<Plot> getAll();
}
