package focik.net.progasoffice.tasks.coordinator.infrastructure.jpa;

import focik.net.progasoffice.share.ActiveStatus;
import focik.net.progasoffice.tasks.coordinator.domain.model.Coordinator;
import focik.net.progasoffice.tasks.coordinator.domain.port.secondary.CoordinatorRepository;
import focik.net.progasoffice.tasks.coordinator.infrastructure.dto.CoordinatorDbDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CoordinatorRepositoryAdapter implements CoordinatorRepository {

    private final CoordinatorDtoRepository coordinatorDtoRepository;
    private final ModelMapper modelMapper;

    @Override
    public Optional<Coordinator> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<Coordinator> findAllByStatus(ActiveStatus status) {
        List<CoordinatorDbDto> dtos = new ArrayList<>();
        switch (status) {
            case ACTIVE:
                dtos = coordinatorDtoRepository.findAllByIsActive(true);
                break;
            case INACTIVE:
                dtos = coordinatorDtoRepository.findAllByIsActive(false);
                break;
            case ALL:
                dtos = coordinatorDtoRepository.findAll();
                break;
        }

        return dtos.stream()
                .map(coordinatorDbDto -> modelMapper.map(coordinatorDbDto, Coordinator.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<Coordinator> findAll() {
        return List.of();
    }

}
