package focik.net.progasoffice.tasks.plot.domain.port.secondary;

import focik.net.progasoffice.tasks.common.domain.model.TaskType;
import focik.net.progasoffice.tasks.plot.domain.model.Plot;
import focik.net.progasoffice.tasks.plot.domain.model.PlotOwnerPrivate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface PlotOwnerPrivateRepository {

    List<PlotOwnerPrivate> findAllByPlot(Integer idPlot);
}
