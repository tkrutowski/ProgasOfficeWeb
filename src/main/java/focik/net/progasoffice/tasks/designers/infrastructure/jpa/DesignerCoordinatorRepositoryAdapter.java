package focik.net.progasoffice.tasks.designers.infrastructure.jpa;

import focik.net.progasoffice.share.ActiveStatus;
import focik.net.progasoffice.tasks.designers.domain.model.Designer;
import focik.net.progasoffice.tasks.designers.domain.model.DesignerTraffic;
import focik.net.progasoffice.tasks.designers.domain.port.secondary.DesignerCoordinatorRepository;
import focik.net.progasoffice.tasks.designers.infrastructure.dto.DesignerDbDto;
import focik.net.progasoffice.tasks.designers.infrastructure.dto.DesignerTrafficDbDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class DesignerCoordinatorRepositoryAdapter implements DesignerCoordinatorRepository {

    private final DesignerDtoRepository designerDtoRepository;
    private final DesignerTrafficDtoRepository designerTrafficDtoRepository;
    private final ModelMapper modelMapper;

    @Override
    public Optional<Designer> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<Designer> findAllByStatus(ActiveStatus status) {
        List<DesignerDbDto> dtos = switch (status) {
            case ACTIVE -> designerDtoRepository.findAllByIsActive(true);
            case INACTIVE -> designerDtoRepository.findAllByIsActive(false);
            case ALL -> designerDtoRepository.findAll();
        };

        return dtos.stream()
                .map(designerDbDto -> modelMapper.map(designerDbDto, Designer.class))
                .sorted(Comparator.comparing(Designer::getLastName))
                .collect(Collectors.toList());
    }

    @Override
    public List<DesignerTraffic> findAllTrafficByStatus(ActiveStatus status) {
        List<DesignerTrafficDbDto> dtos = switch (status) {
            case ACTIVE -> designerTrafficDtoRepository.findAllByIsActive(true);
            case INACTIVE -> designerTrafficDtoRepository.findAllByIsActive(false);
            case ALL -> designerTrafficDtoRepository.findAll();
        };

        return dtos.stream()
                .map(designerDbDto -> modelMapper.map(designerDbDto, DesignerTraffic.class))
                .sorted(Comparator.comparing(DesignerTraffic::getLastName))
                .collect(Collectors.toList());
    }

    @Override
    public List<Designer> findAll() {
        return List.of();
    }

}
