package focik.net.progasoffice.tasks.inspectors.infrastructure.jpa;

import focik.net.progasoffice.tasks.inspectors.infrastructure.dto.InspectorDbDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InspectorDtoRepository extends JpaRepository<InspectorDbDto, Integer> {

    List<InspectorDbDto> findAllByIsActive(Boolean isActive);

}
