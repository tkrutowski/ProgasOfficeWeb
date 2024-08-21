package focik.net.progasoffice.tasks.surveyors.api;

import focik.net.progasoffice.share.ActiveStatus;
import focik.net.progasoffice.tasks.designers.domain.model.Designer;
import focik.net.progasoffice.tasks.surveyors.domain.model.Surveyor;
import focik.net.progasoffice.tasks.surveyors.domain.port.primary.GetSurveyorUseCase;
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
@RequestMapping("/api/v1/surveyor")
public class SurveyorController {

    private final GetSurveyorUseCase getSurveyorUseCase;

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','TASKS_READ', 'TASKS_READ_ALL')")
    ResponseEntity<Surveyor> getSurveyor(@PathVariable Integer id) {
        log.info("SURVEYOR: Try find surveyor for  id = " + id);
        Surveyor surveyor = getSurveyorUseCase.getSurveyorById(id);

        return new ResponseEntity<>(surveyor, HttpStatus.OK);
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','TASKS_READ', 'TASKS_READ_ALL')")
    ResponseEntity<List<Surveyor>> getSurveyors(@RequestParam(name = "status", defaultValue = "ALL") ActiveStatus status) {
        List<Surveyor> designerList = getSurveyorUseCase.getSurveyorsByActive(status);
        return new ResponseEntity<>(designerList, HttpStatus.OK);
    }
}
