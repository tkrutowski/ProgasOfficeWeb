package focik.net.progasoffice.tasks.designers.infrastructure.jpa;

import focik.net.progasoffice.tasks.designers.infrastructure.dto.DesignerDbDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DesignerDtoRepository  extends JpaRepository<DesignerDbDto, Integer> {

    List<DesignerDbDto> findAllByIsActive(Boolean isActive);

}
