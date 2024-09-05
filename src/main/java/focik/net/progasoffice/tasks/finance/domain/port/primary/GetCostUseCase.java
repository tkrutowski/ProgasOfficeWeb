package focik.net.progasoffice.tasks.finance.domain.port.primary;

import focik.net.progasoffice.tasks.common.domain.model.TaskType;
import focik.net.progasoffice.tasks.finance.domain.model.Cost;
import focik.net.progasoffice.tasks.finance.domain.model.CostType;

import java.util.List;

public interface GetCostUseCase {
    List<Cost> getByTask(int idTask, TaskType taskType);

    List<CostType> getCostTypes();
}
