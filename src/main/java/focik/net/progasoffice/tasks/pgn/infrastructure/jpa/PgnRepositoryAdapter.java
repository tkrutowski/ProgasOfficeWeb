package focik.net.progasoffice.tasks.pgn.infrastructure.jpa;

import focik.net.progasoffice.tasks.common.domain.model.TaskType;
import focik.net.progasoffice.tasks.pgn.domain.model.Pgn;
import focik.net.progasoffice.tasks.pgn.domain.port.secondary.PgnRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PgnRepositoryAdapter implements PgnRepository {

    private final PgnDtoRepository pgnDtoRepository;
    private final ModelMapper modelMapper;

    @Override
    public Pgn findPgnByTask(int idTask, TaskType taskType) {
        return pgnDtoRepository.findByIdTaskAndTaskType(idTask, taskType)
                .map(dbDto -> modelMapper.map(dbDto, Pgn.class))
                .orElse(null);
    }
}
