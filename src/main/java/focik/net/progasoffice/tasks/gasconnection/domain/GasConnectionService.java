package focik.net.progasoffice.tasks.gasconnection.domain;

import focik.net.progasoffice.tasks.common.domain.model.TaskType;
import focik.net.progasoffice.tasks.gasconnection.domain.model.GasConnection;
import focik.net.progasoffice.tasks.gasconnection.domain.port.secondary.GasConnectionRepository;
import focik.net.progasoffice.tasks.pgn.domain.PgnFacade;
import focik.net.progasoffice.tasks.plot.domain.PlotFacade;
import focik.net.progasoffice.tasks.workrange.domain.WorkRangeFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class GasConnectionService {

    private final PlotFacade plotFacade;
    private final WorkRangeFacade workRangeFacade;
    private final PgnFacade pgnFacade;
    private final GasConnectionRepository gasConnectionRepository;

    GasConnection getGasConnection(int id) {
        GasConnection gasConnection = gasConnectionRepository.findById(id).orElse(null);

        if (gasConnection != null) {
            gasConnection.setPlots(plotFacade.getByTask(gasConnection.getId(), TaskType.GAS_CONNECTION));
            gasConnection.setWorkRangeGasConnections(workRangeFacade.getWorkRangeGasConnectionsByTask(gasConnection.getId(), TaskType.GAS_CONNECTION));
            gasConnection.setWorkRangeGasStations(workRangeFacade.getWorkRangeGasStationsByTask(gasConnection.getId(), TaskType.GAS_CONNECTION));
            if (gasConnection.getIsPGN())
                gasConnection.setPgn(pgnFacade.getPgnByTask(gasConnection.getId(), TaskType.GAS_CONNECTION));
        }

        return gasConnection;
    }


}
