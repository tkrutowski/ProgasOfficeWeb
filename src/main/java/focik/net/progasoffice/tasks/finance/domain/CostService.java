package focik.net.progasoffice.tasks.finance.domain;

import focik.net.progasoffice.tasks.common.domain.model.TaskType;
import focik.net.progasoffice.tasks.finance.domain.model.Cost;
import focik.net.progasoffice.tasks.finance.domain.model.CostType;
import focik.net.progasoffice.tasks.finance.domain.port.secondary.CostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class CostService {

    private final CostRepository costRepository;

    public List<Cost> getByTask(int idTask, TaskType taskType) {
        return costRepository.findByTask(idTask, taskType);
    }

    public List<CostType> getAllCostTypes() {
        return costRepository.findAllCostType();
    }
}
