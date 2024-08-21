package focik.net.progasoffice.tasks.gasconnection.domain;

import focik.net.progasoffice.share.TaskStatus;
import focik.net.progasoffice.tasks.common.domain.model.Stage;
import focik.net.progasoffice.tasks.gasconnection.domain.model.GasConnection;
import focik.net.progasoffice.tasks.gasconnection.domain.port.primary.GetGasConnectionUseCase;
import focik.net.progasoffice.tasks.gasconnection.domain.port.primary.UpdateGasConnectionUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GasConnectionFacade implements GetGasConnectionUseCase, UpdateGasConnectionUseCase {

    private final GasConnectionService gasConnectionService;


    @Override
    public GasConnection getGasConnectionById(int id) {
        return gasConnectionService.getGasConnection(id);
    }

    @Override
    public List<GasConnection> getGasConnectionByStatus(TaskStatus taskStatus) {
         return gasConnectionService.getGasConnectionByStatus(taskStatus);
    }

    @Override
    public void updateStage(GasConnection gasConnection, Stage newStage) {
        gasConnectionService.updateStage(gasConnection, newStage);
    }
}
