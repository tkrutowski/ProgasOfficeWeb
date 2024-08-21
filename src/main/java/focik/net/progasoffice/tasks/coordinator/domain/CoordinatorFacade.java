package focik.net.progasoffice.tasks.coordinator.domain;

import focik.net.progasoffice.share.ActiveStatus;
import focik.net.progasoffice.tasks.coordinator.domain.model.Coordinator;
import focik.net.progasoffice.tasks.coordinator.domain.port.primary.GetCoordinatorUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CoordinatorFacade implements GetCoordinatorUseCase {

    private final CoordinatorService coordinatorService;
    @Override
    public Coordinator getCoordinatorById(int id) {
        return coordinatorService.getCoordinatorById(id);
    }

}
