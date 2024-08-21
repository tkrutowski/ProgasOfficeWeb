package focik.net.progasoffice.tasks.common.domain.port.secondary;

import focik.net.progasoffice.tasks.common.domain.model.UtilityCompanyType;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UtilityCompanyTypeRepository {
    List<UtilityCompanyType> findAll();
}
