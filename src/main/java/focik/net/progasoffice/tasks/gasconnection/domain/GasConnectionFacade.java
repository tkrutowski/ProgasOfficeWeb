package focik.net.progasoffice.tasks.gasconnection.domain;

import focik.net.progasoffice.tasks.gasconnection.domain.model.GasConnection;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GasConnectionFacade {

    private final GasConnectionService gasConnectionService;


    public GasConnection getGasConnection(int id) {
        return gasConnectionService.getGasConnection(id);
    }
}
