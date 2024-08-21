package focik.net.progasoffice.tasks.coordinator.infrastructure.jpa;

import focik.net.progasoffice.tasks.coordinator.infrastructure.dto.CoordinatorDbDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CoordinatorDtoRepository extends JpaRepository<CoordinatorDbDto, Integer> {

    List<CoordinatorDbDto> findAllByIsActive(Boolean isActive);

}
