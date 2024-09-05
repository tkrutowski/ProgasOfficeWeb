package focik.net.progasoffice.tasks.finance.infrastructure.jpa;

import focik.net.progasoffice.tasks.common.domain.model.TaskType;
import focik.net.progasoffice.tasks.finance.domain.model.Cost;
import focik.net.progasoffice.tasks.finance.domain.model.CostType;
import focik.net.progasoffice.tasks.finance.domain.port.secondary.CostRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CostRepositoryAdapter implements CostRepository {
    private final CostDtoRepository costDtoRepository;
    private final CostTypeDtoRepository costTypeDtoRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<Cost> findByTask(int idTask, TaskType taskType) {
        return costDtoRepository.findAllByIdTaskAndTaskType(idTask, taskType)
                .stream()
                .map(costDbDto -> modelMapper.map(costDbDto, Cost.class))
                .toList();
    }

    @Override
    public List<CostType> findAllCostType() {
        return costTypeDtoRepository.findAll()
                .stream()
                .map(costTypeDbDto -> modelMapper.map(costTypeDbDto, CostType.class))
                .toList();
    }
}
