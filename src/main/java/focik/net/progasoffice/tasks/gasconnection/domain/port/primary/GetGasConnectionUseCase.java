package focik.net.progasoffice.tasks.gasconnection.domain.port.primary;

import focik.net.progasoffice.share.TaskStatus;
import focik.net.progasoffice.tasks.gasconnection.domain.model.GasConnection;

import java.util.List;

public interface GetGasConnectionUseCase {
    GasConnection getGasConnectionById(int id);
    List<GasConnection> getGasConnectionByStatus(TaskStatus taskStatus);
}
