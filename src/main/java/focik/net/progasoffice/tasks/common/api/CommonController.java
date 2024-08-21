package focik.net.progasoffice.tasks.common.api;

import focik.net.progasoffice.share.ActiveStatus;
import focik.net.progasoffice.tasks.common.domain.model.UtilityCompanyType;
import focik.net.progasoffice.tasks.common.domain.port.primary.UtilityCompanyUseCase;
import focik.net.progasoffice.tasks.designers.domain.model.Designer;
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
@RequestMapping("/api/v1/common")
public class CommonController {

    private final UtilityCompanyUseCase utilityCompanyUseCase;


    @GetMapping("/utilityCompanyType")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','TASKS_READ', 'TASKS_READ_ALL')")
    ResponseEntity<List<UtilityCompanyType>> getUtilityCompanyType(@RequestParam(name = "status", defaultValue = "ALL") ActiveStatus status) {
        List<UtilityCompanyType> allList = utilityCompanyUseCase.getAll();
        return new ResponseEntity<>(allList, HttpStatus.OK);
    }

}
