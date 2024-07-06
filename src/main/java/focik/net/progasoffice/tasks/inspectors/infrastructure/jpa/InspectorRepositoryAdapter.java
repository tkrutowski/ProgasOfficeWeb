package focik.net.progasoffice.tasks.inspectors.infrastructure.jpa;

import focik.net.progasoffice.share.ActiveStatus;
import focik.net.progasoffice.tasks.inspectors.domain.model.Inspector;
import focik.net.progasoffice.tasks.inspectors.domain.port.secondary.InspectorRepository;
import focik.net.progasoffice.tasks.inspectors.infrastructure.dto.InspectorDbDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class InspectorRepositoryAdapter implements InspectorRepository {

    //TODO porawic na inspektora!!!!
    private final InspectorDtoRepository inspectorDtoRepository;
    private final ModelMapper modelMapper;

    @Override
    public Optional<Inspector> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<Inspector> findAllByStatus(ActiveStatus status) {
        List<InspectorDbDto> dtos = new ArrayList<>();
        switch (status) {
            case ACTIVE:
                dtos = inspectorDtoRepository.findAllByIsActive(true);
                break;
            case INACTIVE:
                dtos = inspectorDtoRepository.findAllByIsActive(false);
                break;
            case ALL:
                dtos = inspectorDtoRepository.findAll();
                break;
        }

        return dtos.stream()
                .map(inspectorDbDto -> modelMapper.map(inspectorDbDto, Inspector.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<Inspector> findAll() {
        return List.of();
    }

}
