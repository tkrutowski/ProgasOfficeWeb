package focik.net.progasoffice.tasks.common.infrastructure.jpa;

import focik.net.progasoffice.tasks.common.infrastructure.dto.UtilityCompanyTypeDbDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilityCompanyTypeDtoRepository extends JpaRepository<UtilityCompanyTypeDbDto, Integer> {

//    List<UtilityCompanyTypeDbDto> findAllByIsActive(Boolean isActive);

}
