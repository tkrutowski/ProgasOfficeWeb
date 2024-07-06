package focik.net.progasoffice.userservice.domain.port.primary;


import focik.net.progasoffice.userservice.domain.model.Settings;

public interface GetSettingsUseCase {
    Settings getSettingsByUser(Long idUser);
    Settings getUserSettings();
}
