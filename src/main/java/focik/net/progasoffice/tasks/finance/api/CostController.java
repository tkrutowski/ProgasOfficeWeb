package focik.net.progasoffice.tasks.finance.api;

import focik.net.progasoffice.tasks.common.domain.model.TaskType;
import focik.net.progasoffice.tasks.finance.domain.model.Cost;
import focik.net.progasoffice.tasks.finance.domain.model.CostType;
import focik.net.progasoffice.tasks.finance.domain.port.primary.GetCostUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/tasks/cost")
public class CostController {

    private final GetCostUseCase getCostUseCase;
    @GetMapping()
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','TASKS_CONNECTION_FINANCE_READ', 'TASKS_CONNECTION_FINANCE_READ_ALL')")
    ResponseEntity<List<Cost>> getCostByTask(@RequestParam(name = "idTask") Integer idTask, @RequestParam(name = "taskType", defaultValue = "GAS_CONNECTION") TaskType taskType) {
        List<Cost> costsByTask = getCostUseCase.getByTask(idTask, taskType);
        return new ResponseEntity<>(costsByTask, HttpStatus.OK);
    }

    @GetMapping("/type")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','TASKS_READ', 'TASKS_READ_ALL')")
    ResponseEntity<List<CostType>> getCostType() {
        List<CostType> costTypes = getCostUseCase.getCostTypes();
        return new ResponseEntity<>(costTypes, HttpStatus.OK);
    }
}
