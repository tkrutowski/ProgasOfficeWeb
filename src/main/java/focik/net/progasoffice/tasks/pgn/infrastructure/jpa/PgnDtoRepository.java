package focik.net.progasoffice.tasks.pgn.infrastructure.jpa;

import focik.net.progasoffice.tasks.common.domain.model.TaskType;
import focik.net.progasoffice.tasks.pgn.infrastructure.dto.PgnDbDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PgnDtoRepository extends JpaRepository<PgnDbDto, Integer> {

    Optional<PgnDbDto> findByIdTaskAndTaskType(Integer id, TaskType taskType);
}
