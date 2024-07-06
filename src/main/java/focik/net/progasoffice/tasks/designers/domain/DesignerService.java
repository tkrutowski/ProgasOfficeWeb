package focik.net.progasoffice.tasks.designers.domain;

import focik.net.progasoffice.share.ActiveStatus;
import focik.net.progasoffice.share.TaskStatus;
import focik.net.progasoffice.tasks.designers.domain.exception.DesignerDoesNotExistException;
import focik.net.progasoffice.tasks.designers.domain.model.Designer;
import focik.net.progasoffice.tasks.designers.domain.port.secondary.DesignerRepository;
import focik.net.progasoffice.tasks.gasconnection.domain.exceptions.GasConnectionDoesNotExistException;
import focik.net.progasoffice.tasks.gasconnection.domain.port.primary.GetGasConnectionQueryUseCase;
import focik.net.progasoffice.tasks.gasconnection.domain.port.secondary.GasConnectionQueryRepository;
import focik.net.progasoffice.tasks.gasconnection.infrastructure.dto.GasConnectionQueryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
class DesignerService{
    private final DesignerRepository designerRepository;


    public Designer getDesignerById(int id) {
        return designerRepository.findById(id).orElseThrow(() -> new DesignerDoesNotExistException(id));
    }

    public List<Designer> getDesignerByActive(ActiveStatus status) {
        return designerRepository.findAllByStatus(status);
    }

    public List<Designer> getDesignersInCompanyByActive(ActiveStatus status) {
        return designerRepository.findAllByStatus(status).stream()
                .filter(Designer::isEmployee)
                .toList();
    }
}
