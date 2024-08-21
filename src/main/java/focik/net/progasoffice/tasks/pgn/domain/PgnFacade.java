package focik.net.progasoffice.tasks.pgn.domain;

import focik.net.progasoffice.tasks.common.domain.model.TaskType;
import focik.net.progasoffice.tasks.pgn.domain.model.Pgn;
import focik.net.progasoffice.tasks.pgn.domain.port.primary.GetPgnUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PgnFacade implements GetPgnUseCase {

    private final PgnService pgnService;


    @Override
    public Pgn getPgnByTask(int idTask, TaskType taskType) {
        return pgnService.getPgnByTask(idTask, taskType);
    }
}
