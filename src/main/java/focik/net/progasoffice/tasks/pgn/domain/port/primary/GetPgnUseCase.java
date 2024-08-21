package focik.net.progasoffice.tasks.pgn.domain.port.primary;

import focik.net.progasoffice.tasks.common.domain.model.TaskType;
import focik.net.progasoffice.tasks.pgn.domain.model.Pgn;

public interface GetPgnUseCase {

    Pgn getPgnByTask(int idTask, TaskType taskType);
}
