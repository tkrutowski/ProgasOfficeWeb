package focik.net.progasoffice.tasks.designers.domain;

import focik.net.progasoffice.share.ActiveStatus;
import focik.net.progasoffice.share.TaskStatus;
import focik.net.progasoffice.tasks.designers.domain.model.Designer;
import focik.net.progasoffice.tasks.designers.domain.port.primary.GetDesignerUseCase;
import focik.net.progasoffice.tasks.gasconnection.domain.exceptions.GasConnectionDoesNotExistException;
import focik.net.progasoffice.tasks.gasconnection.domain.port.primary.GetGasConnectionQueryUseCase;
import focik.net.progasoffice.tasks.gasconnection.domain.port.secondary.GasConnectionQueryRepository;
import focik.net.progasoffice.tasks.gasconnection.infrastructure.dto.GasConnectionQueryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DesignerFacade implements GetDesignerUseCase {

    private final DesignerService designerService;
    @Override
    public Designer getDesignerById(int id) {
        return designerService.getDesignerById(id);
    }

    @Override
    public List<Designer> getDesignersByActive(ActiveStatus status) {
        return designerService.getDesignerByActive(status);
    }

    @Override
    public List<Designer> getAllDesignersInCompany(ActiveStatus status) {
        return designerService.getDesignersInCompanyByActive(status);
    }
}
