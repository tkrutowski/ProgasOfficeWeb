package focik.net.progasoffice.tasks.designers.api;

import focik.net.progasoffice.share.ActiveStatus;
import focik.net.progasoffice.tasks.designers.domain.model.Designer;
import focik.net.progasoffice.tasks.designers.domain.port.primary.GetDesignerUseCase;
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
@RequestMapping("/api/v1/designer")
public class DesignerController {

    private final GetDesignerUseCase getDesignerUseCase;

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','TASKS_READ', 'TASKS_READ_ALL')")
    ResponseEntity<Designer> getDesigner(@PathVariable Integer id) {
        log.info("DESIGNER: Try find designer for  id = " + id);
        Designer designer = getDesignerUseCase.getDesignerById(id);

        return new ResponseEntity<>(designer, HttpStatus.OK);
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','TASKS_READ', 'TASKS_READ_ALL')")
    ResponseEntity<List<Designer>> getDesigners(@RequestParam(name = "status", defaultValue = "ALL") ActiveStatus status) {
        List<Designer> designerList = getDesignerUseCase.getDesignersByActive(status);
        return new ResponseEntity<>(designerList, HttpStatus.OK);
    }

}
