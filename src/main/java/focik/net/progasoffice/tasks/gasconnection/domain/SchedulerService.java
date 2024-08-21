package focik.net.progasoffice.tasks.gasconnection.domain;

import focik.net.progasoffice.share.TaskStatus;
import focik.net.progasoffice.tasks.common.domain.model.Stage;
import focik.net.progasoffice.tasks.gasconnection.domain.model.GasConnection;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
class SchedulerService {

    private static final Logger log = LoggerFactory.getLogger(SchedulerService.class);
    private final GasConnectionFacade gasConnectionFacade;

    //    @Scheduled(cron = "0 */10 * * * *")
//    @Scheduled(cron = "15 * * * * *")
    @Scheduled(cron = "0 0 23 * * *")
    public void updateGasConnectionStages() {
        log.info("SCHEDULER - Start: {}", LocalDateTime.now());
        List<GasConnection> gasConnectionByStatus = gasConnectionFacade.getGasConnectionByStatus(TaskStatus.NOT_FINISHED);
        log.info("SCHEDULER - size: {}", gasConnectionByStatus.size());

        int counter = 1;
        for (GasConnection gasConnection : gasConnectionByStatus) {
            log.info("SCHEDULER - processing {} z {}, ID = {}", counter++, gasConnectionByStatus.size(), gasConnection.getId());
            //sprawdzić czy nie jset zablokowane
            if (isBlocked(gasConnection)) {
                continue;
            }

            log.info("SCHEDULER - stage BEFORE: {}", gasConnection.getStage());
            Stage stage = gasConnection.calculateStage();
            if (!gasConnection.getStage().equals(stage)) {
                gasConnectionFacade.updateStage(gasConnection, stage);
                log.info("SCHEDULER - stage AFTER: {}", stage);
            } else {
                log.info("SCHEDULER - stage EQUAL: {}", stage);
            }
        }
        log.info("SCHEDULER - End: {}", LocalDateTime.now());
    }

    private boolean isBlocked(GasConnection gasConnection) {
        return false;
    }

    //        @Scheduled(cron = "15 * * * * *")
    public void testupdateGasConnectionStages() {
        log.info("SCHEDULER - Start: {}", LocalDateTime.now());
        GasConnection gasConnectionById = gasConnectionFacade.getGasConnectionById(1741);
        log.info("SCHEDULER - stage before: {}", gasConnectionById.getStage());

        Stage stage = gasConnectionById.calculateStage();

        gasConnectionFacade.updateStage(gasConnectionById, stage);

        GasConnection gas = gasConnectionFacade.getGasConnectionById(2668);
        log.info("SCHEDULER - stage after: {}", stage);
//        for (GasConnection gasConnection : gasConnectionByStatus) {
//            //sprawdzić czy nie jset zablokowane
//            if (isBlocked(gasConnection)){
//                continue;
//            }
//            Stage stage = gasConnection.calculateStage();
//            if (gasConnection.getStage() != stage.getValue()){
//                //aktualiozacja w bazie
//            }
//        }


        log.info("SCHEDULER - End: {}", LocalDateTime.now());
    }
}
