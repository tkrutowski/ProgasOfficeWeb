package focik.net.progasoffice.tasks.gasconnection.api;

import focik.net.progasoffice.share.TaskStatus;
import focik.net.progasoffice.tasks.gasconnection.domain.port.primary.GetGasConnectionQueryUseCase;
import focik.net.progasoffice.tasks.gasconnection.infrastructure.dto.GasConnectionQueryDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Log4j2
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/query/gasconnection")
public class  GasConnectionQueryController {

    private final GetGasConnectionQueryUseCase queryUseCase;

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','TASKS_READ', 'TASKS_READ_ALL')")
    ResponseEntity<GasConnectionQueryDto> getGasConnection(@PathVariable Integer id) {
        log.info("GASCONNECTION: Try find gasconnection for  id = " + id);
        GasConnectionQueryDto gasConnectionDto = queryUseCase.getGasConnectionById(id);

        return new ResponseEntity<>(gasConnectionDto, HttpStatus.OK);
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','TASKS_READ', 'TASKS_READ_ALL')")
    ResponseEntity<List<GasConnectionQueryDto>> getGasConnections(@RequestParam(name = "status", defaultValue = "ALL") TaskStatus taskStatus) {
        List<GasConnectionQueryDto> gasConnectionByComplete = queryUseCase.getGasConnectionByStatus(taskStatus);
        return new ResponseEntity<>(gasConnectionByComplete, HttpStatus.OK);
    }
}
