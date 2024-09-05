package focik.net.progasoffice.tasks.finance.domain;

import focik.net.progasoffice.tasks.common.domain.model.TaskType;
import focik.net.progasoffice.tasks.finance.domain.model.Cost;
import focik.net.progasoffice.tasks.finance.domain.model.CostType;
import focik.net.progasoffice.tasks.finance.domain.port.primary.GetCostUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CostFacade  implements GetCostUseCase {
    private final CostService costService;

    @Override
    public List<Cost> getByTask(int idTask, TaskType taskType) {
        return costService.getByTask(idTask, taskType);
    }

    @Override
    public List<CostType> getCostTypes() {
        return costService.getAllCostTypes();
    }
}
