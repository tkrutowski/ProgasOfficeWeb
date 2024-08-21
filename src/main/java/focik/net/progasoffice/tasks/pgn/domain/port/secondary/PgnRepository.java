package focik.net.progasoffice.tasks.pgn.domain.port.secondary;

import focik.net.progasoffice.tasks.common.domain.model.TaskType;
import focik.net.progasoffice.tasks.pgn.domain.model.Pgn;
import org.springframework.stereotype.Component;

@Component
public interface PgnRepository {

    Pgn findPgnByTask(int idTask, TaskType taskType);

}
