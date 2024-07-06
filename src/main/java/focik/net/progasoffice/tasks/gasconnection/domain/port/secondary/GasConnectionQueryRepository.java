package focik.net.progasoffice.tasks.gasconnection.domain.port.secondary;

import focik.net.progasoffice.tasks.gasconnection.infrastructure.dto.GasConnectionQueryDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface GasConnectionQueryRepository {

    Optional<GasConnectionQueryDto> findById(Integer id);

    List<GasConnectionQueryDto> findAllByComplete(Boolean isCompleted);

    List<GasConnectionQueryDto> findAll();

    List<GasConnectionQueryDto> findAllNotFinished();

    List<GasConnectionQueryDto> findAllNotFinishedTech();

    List<GasConnectionQueryDto> findAllNotFinishedEnd();

    List<GasConnectionQueryDto> findAllOverdue();

}
