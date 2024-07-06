package focik.net.progasoffice.userservice.api;

import focik.net.progasoffice.userservice.domain.model.Settings;
import focik.net.progasoffice.userservice.domain.port.primary.GetSettingsUseCase;
import focik.net.progasoffice.userservice.domain.port.primary.SaveSettingsUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

//@CrossOrigin
@Log4j2
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/settings")
public class SettingsController {

    private final GetSettingsUseCase getSettingsUseCase;
    private final SaveSettingsUseCase saveSettingsUseCase;

    @GetMapping
//    @PreAuthorize("hasAnyAuthority('ADMIN_READ_ALL','USER_READ')")
    public ResponseEntity<Settings> getSettings() throws IOException {
        System.out.println();
        Settings settings = getSettingsUseCase.getUserSettings();
        return ResponseEntity.ok(settings);
    }

    @PutMapping
//    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','USER_READ')")
    public ResponseEntity<Settings> saveSettings(@RequestBody Settings settings) throws IOException {
        System.out.print("");
        Settings saved = saveSettingsUseCase.saveAll(settings);
        return ResponseEntity.ok(saved);
    }
}
