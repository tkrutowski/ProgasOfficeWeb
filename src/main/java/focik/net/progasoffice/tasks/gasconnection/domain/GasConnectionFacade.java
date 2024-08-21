package focik.net.progasoffice.tasks.gasconnection.domain;

import focik.net.progasoffice.share.TaskStatus;
import focik.net.progasoffice.tasks.gasconnection.domain.model.GasConnection;
import focik.net.progasoffice.tasks.gasconnection.domain.port.primary.GetGasConnectionUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GasConnectionFacade implements GetGasConnectionUseCase {

    private final GasConnectionService gasConnectionService;


    public GasConnection getGasConnection(int id) {
        return gasConnectionService.getGasConnection(id);
    }

    @Override
    public GasConnection getGasConnectionById(int id) {
        return gasConnectionService.getGasConnection(id);
    }

    @Override
    public List<GasConnection> getGasConnectionByStatus(TaskStatus taskStatus) {
        return List.of();
    }
}
