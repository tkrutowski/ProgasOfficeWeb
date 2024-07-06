package focik.net.progasoffice.tasks.gasconnection.domain;

import focik.net.progasoffice.customers.domain.CustomerFacade;
import focik.net.progasoffice.tasks.gasconnection.domain.model.GasConnection;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class GasConnectionService {

    CustomerFacade customerFacade;

    GasConnection getGasConnection(int id) {
        return new GasConnection();
    }



}
