package focik.net.progasoffice.tasks.plot.infrastructure.jpa;

import focik.net.progasoffice.tasks.common.domain.model.TaskType;
import focik.net.progasoffice.tasks.common.domain.model.UtilityCompanyType;
import focik.net.progasoffice.tasks.common.domain.port.secondary.UtilityCompanyTypeRepository;
import focik.net.progasoffice.tasks.plot.domain.model.Plot;
import focik.net.progasoffice.tasks.plot.domain.port.secondary.PlotRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PlotRepositoryAdapter implements PlotRepository {

    private final PlotDtoRepository plotDtoRepository;
    private final ModelMapper modelMapper;


    @Override
    public Optional<Plot> getById(int id) {
        return plotDtoRepository.findById(id)
                .map(plotDbDto ->  modelMapper.map(plotDbDto, Plot.class))
                .or(Optional::empty);
    }

    @Override
    public List<Plot> findByTask(int idTask, TaskType taskType) {
        return plotDtoRepository.findAllByIdTaskAndTaskType(idTask, taskType)
                .stream()
                .map(plotDbDto -> modelMapper.map(plotDbDto, Plot.class))
                .toList();
    }

    @Override
    public List<Plot> findAll() {
        return plotDtoRepository.findAll()
                .stream()
                .map(plotDbDto -> modelMapper.map(plotDbDto, Plot.class))
                .toList();
    }

}
