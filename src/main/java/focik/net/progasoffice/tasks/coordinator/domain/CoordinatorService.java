package focik.net.progasoffice.tasks.coordinator.domain;

import focik.net.progasoffice.tasks.coordinator.domain.exception.CoordinatorDoesNotExistException;
import focik.net.progasoffice.tasks.coordinator.domain.model.Coordinator;
import focik.net.progasoffice.tasks.coordinator.domain.port.secondary.CoordinatorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class CoordinatorService {
    private final CoordinatorRepository coordinatorRepository;


    public Coordinator getCoordinatorById(int id) {
        return coordinatorRepository.findById(id).orElseThrow(() -> new CoordinatorDoesNotExistException(id));
    }

}
