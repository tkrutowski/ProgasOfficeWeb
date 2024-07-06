package focik.net.progasoffice.tasks.inspectors.domain;

import focik.net.progasoffice.share.ActiveStatus;
import focik.net.progasoffice.tasks.inspectors.domain.exception.InspectorDoesNotExistException;
import focik.net.progasoffice.tasks.inspectors.domain.model.Inspector;
import focik.net.progasoffice.tasks.inspectors.domain.port.secondary.InspectorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class InspectorService {
    private final InspectorRepository inspectorRepository;


    public Inspector getInspectorById(int id) {
        return inspectorRepository.findById(id).orElseThrow(() -> new InspectorDoesNotExistException(id));
    }

    public List<Inspector> getInspectorByActive(ActiveStatus status) {
        return inspectorRepository.findAllByStatus(status);
    }

}
