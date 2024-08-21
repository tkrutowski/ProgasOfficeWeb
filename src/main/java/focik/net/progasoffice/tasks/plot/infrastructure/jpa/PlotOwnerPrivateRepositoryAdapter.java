package focik.net.progasoffice.tasks.plot.infrastructure.jpa;

import focik.net.progasoffice.tasks.plot.domain.model.PlotOwnerPrivate;
import focik.net.progasoffice.tasks.plot.domain.port.secondary.PlotOwnerPrivateRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PlotOwnerPrivateRepositoryAdapter implements PlotOwnerPrivateRepository {

    private final PlotOwnerPrivateDtoRepository plotOwnerPrivateDtoRepository;
    private final ModelMapper modelMapper;


    @Override
    public List<PlotOwnerPrivate> findAllByPlot(Integer idPlot) {
        return plotOwnerPrivateDtoRepository.findAllByIdPlot(idPlot)
                .stream()
                .map(plotDbDto -> modelMapper.map(plotDbDto, PlotOwnerPrivate.class))
                .toList();
    }
}
