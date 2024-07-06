package focik.net.progasoffice.tasks.inspectors.domain;

import focik.net.progasoffice.share.ActiveStatus;
import focik.net.progasoffice.tasks.inspectors.domain.model.Inspector;
import focik.net.progasoffice.tasks.inspectors.domain.port.primary.GetInspectorUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class InspectorFacade implements GetInspectorUseCase {

    private final InspectorService inspectorService;
    @Override
    public Inspector getInspectorById(int id) {
        return inspectorService.getInspectorById(id);
    }

    @Override
    public List<Inspector> getInspectorsByActive(ActiveStatus status) {
        return inspectorService.getInspectorByActive(status);
    }
}
