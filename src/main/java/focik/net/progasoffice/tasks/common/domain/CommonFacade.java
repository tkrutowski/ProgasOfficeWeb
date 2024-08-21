package focik.net.progasoffice.tasks.common.domain;

import focik.net.progasoffice.tasks.common.domain.model.UtilityCompanyType;
import focik.net.progasoffice.tasks.common.domain.port.primary.UtilityCompanyUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CommonFacade implements UtilityCompanyUseCase {

    private final CommonService commonService;
    @Override
    public List<UtilityCompanyType> getAll() {
        return commonService.getUtilityCompanies();
    }

}
