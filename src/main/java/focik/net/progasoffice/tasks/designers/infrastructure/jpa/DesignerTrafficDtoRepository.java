package focik.net.progasoffice.tasks.designers.infrastructure.jpa;

import focik.net.progasoffice.tasks.designers.infrastructure.dto.DesignerTrafficDbDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DesignerTrafficDtoRepository extends JpaRepository<DesignerTrafficDbDto, Integer> {

    List<DesignerTrafficDbDto> findAllByIsActive(Boolean isActive);

}
