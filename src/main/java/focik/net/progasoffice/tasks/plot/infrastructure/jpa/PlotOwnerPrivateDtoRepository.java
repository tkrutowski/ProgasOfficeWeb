package focik.net.progasoffice.tasks.plot.infrastructure.jpa;

import focik.net.progasoffice.tasks.common.domain.model.TaskType;
import focik.net.progasoffice.tasks.plot.infrastructure.dto.PlotDbDto;
import focik.net.progasoffice.tasks.plot.infrastructure.dto.PlotOwnerPrivateDbDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PlotOwnerPrivateDtoRepository extends JpaRepository<PlotOwnerPrivateDbDto, Integer> {

    List<PlotOwnerPrivateDbDto> findAllByIdPlot(Integer idPlot);
}
