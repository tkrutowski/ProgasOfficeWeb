package focik.net.progasoffice.tasks.designers.domain;

import focik.net.progasoffice.share.ActiveStatus;
import focik.net.progasoffice.tasks.designers.domain.exception.DesignerDoesNotExistException;
import focik.net.progasoffice.tasks.designers.domain.model.Designer;
import focik.net.progasoffice.tasks.designers.domain.model.DesignerTraffic;
import focik.net.progasoffice.tasks.designers.domain.port.secondary.DesignerCoordinatorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class DesignerService{
    private final DesignerCoordinatorRepository designerCoordinatorRepository;


    public Designer getDesignerById(int id) {
        return designerCoordinatorRepository.findById(id).orElseThrow(() -> new DesignerDoesNotExistException(id));
    }

    public List<Designer> getDesignerByActive(ActiveStatus status) {
        return designerCoordinatorRepository.findAllByStatus(status);
    }

    public List<Designer> getDesignersInCompanyByActive(ActiveStatus status) {
        return designerCoordinatorRepository.findAllByStatus(status).stream()
                .filter(Designer::isEmployee)
                .toList();
    }

    public List<DesignerTraffic> getDesignerTrafficByActive(ActiveStatus status) {
        return designerCoordinatorRepository.findAllTrafficByStatus(status);
    }
}
