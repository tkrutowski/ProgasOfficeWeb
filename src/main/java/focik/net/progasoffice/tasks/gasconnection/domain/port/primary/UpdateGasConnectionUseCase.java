package focik.net.progasoffice.tasks.gasconnection.domain.port.primary;

import focik.net.progasoffice.tasks.common.domain.model.Stage;
import focik.net.progasoffice.tasks.gasconnection.domain.model.GasConnection;

public interface UpdateGasConnectionUseCase {
    void updateStage(GasConnection gasConnection, Stage newStage);
}
