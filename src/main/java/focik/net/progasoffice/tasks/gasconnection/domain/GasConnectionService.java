package focik.net.progasoffice.tasks.gasconnection.domain;

import focik.net.progasoffice.share.TaskStatus;
import focik.net.progasoffice.tasks.common.domain.model.Stage;
import focik.net.progasoffice.tasks.common.domain.model.TaskType;
import focik.net.progasoffice.tasks.gasconnection.domain.model.GasConnection;
import focik.net.progasoffice.tasks.gasconnection.domain.port.secondary.GasConnectionRepository;
import focik.net.progasoffice.tasks.pgn.domain.PgnFacade;
import focik.net.progasoffice.tasks.plot.domain.PlotFacade;
import focik.net.progasoffice.tasks.workrange.domain.WorkRangeFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
            fillGasConnection(gasConnection);
        }

        return gasConnection;
    }

    private void fillGasConnection(GasConnection gasConnection) {
        gasConnection.setPlots(plotFacade.getByTask(gasConnection.getId(), TaskType.GAS_CONNECTION));
        gasConnection.setWorkRangeGasConnections(workRangeFacade.getWorkRangeGasConnectionsByTask(gasConnection.getId(), TaskType.GAS_CONNECTION));
        gasConnection.setWorkRangeGasStations(workRangeFacade.getWorkRangeGasStationsByTask(gasConnection.getId(), TaskType.GAS_CONNECTION));
        if (gasConnection.getIsPGN())
            gasConnection.setPgn(pgnFacade.getPgnByTask(gasConnection.getId(), TaskType.GAS_CONNECTION));
    }

    void updateStage(GasConnection gasConnection, Stage newStage) {
        gasConnectionRepository.updateStage(gasConnection.getId(), newStage);
    }

    public List<GasConnection> getGasConnectionByStatus(TaskStatus taskStatus) {

        List<GasConnection> gasConnectionList =  switch (taskStatus) {
            case ALL -> gasConnectionRepository.findAll();
            case FINISHED ->  gasConnectionRepository.findAllByFinish(true);
            case OVER_DUE ->  List.of();
            case NOT_FINISHED ->  gasConnectionRepository.findAllByFinish(false);
            case NOT_FINISHED_END -> List.of();
            case NOT_FINISHED_TECH -> List.of();
        };

        gasConnectionList.forEach(this::fillGasConnection);
        return gasConnectionList;
    }
}
