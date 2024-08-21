package focik.net.progasoffice.tasks.plot.domain;

import focik.net.progasoffice.tasks.common.domain.model.TaskType;
import focik.net.progasoffice.tasks.plot.domain.model.Plot;
import focik.net.progasoffice.tasks.plot.domain.port.primary.GetPlotUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PlotFacade implements GetPlotUseCase {

    private final PlotService plotService;

    @Override
    public Plot getById(int id) {
        return plotService.getById(id);
    }

    @Override
    public List<Plot> getByTask(int idTask, TaskType taskType) {
        return plotService.getByTask(idTask, taskType);
    }

    @Override
    public List<Plot> getAll() {
        return List.of();
    }
}
