package focik.net.progasoffice.tasks.common.infrastructure.jpa;

import focik.net.progasoffice.tasks.common.domain.model.UtilityCompanyType;
import focik.net.progasoffice.tasks.common.domain.port.secondary.UtilityCompanyTypeRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UtilityCompanyTypeRepositoryAdapter implements UtilityCompanyTypeRepository {

    private final UtilityCompanyTypeDtoRepository utilityCompanyTypeDtoRepository;
    private final ModelMapper modelMapper;


    @Override
    public List<UtilityCompanyType> findAll() {

        return utilityCompanyTypeDtoRepository.findAll()
                .stream()
                .map(utilityCompanyTypeDbDto -> modelMapper.map(utilityCompanyTypeDbDto, UtilityCompanyType.class))
                .toList();
    }

}
