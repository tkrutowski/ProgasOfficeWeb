package focik.net.progasoffice.tasks.common.domain.port.primary;

import focik.net.progasoffice.tasks.common.domain.model.UtilityCompanyType;

import java.util.List;

public interface UtilityCompanyUseCase {
    List<UtilityCompanyType> getAll();
}
