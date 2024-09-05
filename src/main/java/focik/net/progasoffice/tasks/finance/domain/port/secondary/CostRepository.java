package focik.net.progasoffice.tasks.finance.domain.port.secondary;

import focik.net.progasoffice.tasks.common.domain.model.TaskType;
import focik.net.progasoffice.tasks.finance.domain.model.Cost;
import focik.net.progasoffice.tasks.finance.domain.model.CostType;

import java.util.List;

public interface CostRepository {

    List<Cost> findByTask(int idTask, TaskType taskType);

    List<CostType> findAllCostType();
}
