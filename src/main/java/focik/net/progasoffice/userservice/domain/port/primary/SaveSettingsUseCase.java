package focik.net.progasoffice.userservice.domain.port.primary;


import focik.net.progasoffice.userservice.domain.model.Settings;

import java.io.IOException;

public interface SaveSettingsUseCase {
    Settings saveAll(Settings settings) throws IOException;
}
