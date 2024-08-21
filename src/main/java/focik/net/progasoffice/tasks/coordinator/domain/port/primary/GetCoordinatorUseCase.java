package focik.net.progasoffice.tasks.coordinator.domain.port.primary;

import focik.net.progasoffice.share.ActiveStatus;
import focik.net.progasoffice.tasks.coordinator.domain.model.Coordinator;

import java.util.List;

public interface GetCoordinatorUseCase {
    Coordinator getCoordinatorById(int id);
}
