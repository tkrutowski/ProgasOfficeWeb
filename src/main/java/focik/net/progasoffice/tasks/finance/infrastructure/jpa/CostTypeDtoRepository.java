package focik.net.progasoffice.tasks.finance.infrastructure.jpa;

import focik.net.progasoffice.tasks.finance.infrastructure.dto.CostTypeDbDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CostTypeDtoRepository extends JpaRepository<CostTypeDbDto, Integer> {

}
