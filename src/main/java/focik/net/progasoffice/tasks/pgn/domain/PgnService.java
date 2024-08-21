package focik.net.progasoffice.tasks.pgn.domain;

import focik.net.progasoffice.tasks.common.domain.model.TaskType;
import focik.net.progasoffice.tasks.pgn.domain.model.Pgn;
import focik.net.progasoffice.tasks.pgn.domain.port.secondary.PgnRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class PgnService {
    private final PgnRepository pgnRepository;

    public Pgn getPgnByTask(int idTask, TaskType taskType) {
        return pgnRepository.findPgnByTask(idTask, taskType);
    }
}
