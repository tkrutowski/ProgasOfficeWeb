package focik.net.progasoffice.tasks.gasconnection.domain.port.primary;

import focik.net.progasoffice.share.TaskStatus;
import focik.net.progasoffice.tasks.gasconnection.infrastructure.dto.GasConnectionQueryDto;

import java.util.List;

public interface GetGasConnectionQueryUseCase {
    GasConnectionQueryDto getGasConnectionById(int id);
    List<GasConnectionQueryDto> getGasConnectionByStatus(TaskStatus taskStatus);
}
