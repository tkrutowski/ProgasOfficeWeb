package focik.net.progasoffice.userservice.domain.port.secondary;


import focik.net.progasoffice.userservice.domain.model.Settings;

public interface SettingsRepository {

    Settings addDefaultSettings(Settings settings);
    Settings getSettingsByUserId(Long idUser);
    void saveSettings(Settings settings);
}
