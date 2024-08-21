package focik.net.progasoffice.tasks.plot.api;

import focik.net.progasoffice.share.ActiveStatus;
import focik.net.progasoffice.tasks.common.domain.model.TaskType;
import focik.net.progasoffice.tasks.common.domain.model.UtilityCompanyType;
import focik.net.progasoffice.tasks.plot.domain.model.Plot;
import focik.net.progasoffice.tasks.plot.domain.port.primary.GetPlotUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin
@Log4j2
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/tasks/plot")
public class PlotController {

    private final GetPlotUseCase getPlotUseCase;


    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','TASKS_READ', 'TASKS_READ_ALL')")
    ResponseEntity<Plot> getPlotById(@PathVariable Integer id) {
        Plot plot = getPlotUseCase.getById(id);
        return new ResponseEntity<>(plot, HttpStatus.OK);
    }

    @GetMapping()
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','TASKS_READ', 'TASKS_READ_ALL')")
    ResponseEntity<List<Plot>> getPlotByTask(@RequestParam(name = "idTask") Integer idTask, @RequestParam(name = "taskType", defaultValue = "GAS_CONNECTION") TaskType taskType) {
        List<Plot> plots = getPlotUseCase.getByTask(idTask, taskType);
        return new ResponseEntity<>(plots, HttpStatus.OK);
    }

}
