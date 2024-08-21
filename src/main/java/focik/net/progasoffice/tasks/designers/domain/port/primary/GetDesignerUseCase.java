package focik.net.progasoffice.tasks.designers.domain.port.primary;

import focik.net.progasoffice.share.ActiveStatus;
import focik.net.progasoffice.tasks.designers.domain.model.Designer;
import focik.net.progasoffice.tasks.designers.domain.model.DesignerTraffic;

import java.util.List;

public interface GetDesignerUseCase {
    Designer getDesignerById(int id);

    List<Designer> getDesignersByActive(ActiveStatus status);
    List<DesignerTraffic> getDesignersTrafficByActive(ActiveStatus status);
    List<Designer> getAllDesignersInCompany(ActiveStatus status);

}
