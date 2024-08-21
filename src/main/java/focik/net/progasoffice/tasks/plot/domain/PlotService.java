package focik.net.progasoffice.tasks.plot.domain;

import focik.net.progasoffice.tasks.common.domain.model.TaskType;
import focik.net.progasoffice.tasks.plot.domain.model.Plot;
import focik.net.progasoffice.tasks.plot.domain.port.secondary.PlotOwnerPrivateRepository;
import focik.net.progasoffice.tasks.plot.domain.port.secondary.PlotRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class PlotService {
    private final PlotRepository plotRepository;
    private final PlotOwnerPrivateRepository plotOwnerPrivateRepository;


    public List<Plot> getByTask(int idTask, TaskType taskType) {
        List<Plot> plots = plotRepository.findByTask(idTask, taskType);
        plots.forEach(this::addPlotOwnerPrivate);
        return plots;
    }

    public Plot getById(int id) {
        Plot plot = plotRepository.getById(id).orElse(null);
        if (plot != null) {
            addPlotOwnerPrivate(plot);
        }
        return plot;
    }

    private void addPlotOwnerPrivate(Plot plot) {
        plot.setPlotOwnerPrivate(plotOwnerPrivateRepository.findAllByPlot(plot.getId()));
    }
}
