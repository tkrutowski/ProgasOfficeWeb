package focik.net.progasoffice.tasks.gasconnection.api;

import focik.net.progasoffice.share.TaskStatus;
import focik.net.progasoffice.tasks.common.domain.model.Stage;
import focik.net.progasoffice.tasks.gasconnection.domain.model.GasConnection;
import focik.net.progasoffice.tasks.gasconnection.domain.port.primary.GetGasConnectionUseCase;
import focik.net.progasoffice.tasks.gasconnection.infrastructure.dto.GasConnectionQueryDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Log4j2
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/gasconnection")
public class GasConnectionController {

    private final GetGasConnectionUseCase gasConnectionUseCase;

    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','TASKS_CONNECTION_DESIGN_READ', 'TASKS_CONNECTION_DESIGN_READ_ALL')")
    ResponseEntity<GasConnection> getGasConnection(@PathVariable Integer id) {
        log.info("GASCONNECTION: Try find gasconnection for  id = " + id);
        GasConnection gasConnectionDto = gasConnectionUseCase.getGasConnectionById(id);

        return new ResponseEntity<>(gasConnectionDto, HttpStatus.OK);
    }

    @GetMapping("/stage/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','TASKS_CONNECTION_DESIGN_READ', 'TASKS_CONNECTION_DESIGN_READ_ALL')")
    ResponseEntity<Stage> getGasConnectionStage(@PathVariable Integer id) {
        log.info("GASCONNECTION: Try find gasconnection for  id = " + id);
        GasConnection gasConnectionDto = gasConnectionUseCase.getGasConnectionById(id);

        return new ResponseEntity<>(gasConnectionDto.calculateStage(), HttpStatus.OK);
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','TASKS_CONNECTION_DESIGN_READ', 'TASKS_CONNECTION_DESIGN_READ_ALL')")
    ResponseEntity<List<GasConnection>> getGasConnections(@RequestParam(name = "status", defaultValue = "ALL") TaskStatus taskStatus) {
        List<GasConnection> gasConnectionByComplete = gasConnectionUseCase.getGasConnectionByStatus(taskStatus);
        return new ResponseEntity<>(gasConnectionByComplete, HttpStatus.OK);
    }
}
