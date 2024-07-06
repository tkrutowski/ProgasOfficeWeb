package focik.net.progasoffice.tasks.inspectors.domain.port.primary;

import focik.net.progasoffice.share.ActiveStatus;
import focik.net.progasoffice.tasks.inspectors.domain.model.Inspector;

import java.util.List;

public interface GetInspectorUseCase {
    Inspector getInspectorById(int id);

    List<Inspector> getInspectorsByActive(ActiveStatus status);

}
