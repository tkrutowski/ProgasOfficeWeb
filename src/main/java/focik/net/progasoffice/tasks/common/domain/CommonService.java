package focik.net.progasoffice.tasks.common.domain;

import focik.net.progasoffice.tasks.common.domain.model.UtilityCompanyType;
import focik.net.progasoffice.tasks.common.domain.port.secondary.UtilityCompanyTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class CommonService {
private final UtilityCompanyTypeRepository utilityCompanyRepository;


    public List<UtilityCompanyType> getUtilityCompanies() {
        return utilityCompanyRepository.findAll();
    }

}
