package focik.net.progasoffice.userservice.domain;


import com.fasterxml.jackson.databind.ObjectMapper;
import focik.net.progasoffice.share.DisplayByOwnershipEnum;
import focik.net.progasoffice.userservice.domain.port.secondary.SettingsRepository;
import focik.net.progasoffice.userservice.domain.model.Settings;
import focik.net.progasoffice.userservice.domain.utility.UserHelper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
@RequiredArgsConstructor
@Slf4j
public class SettingsService {
    private final SettingsRepository settingsRepository;
    private final ObjectMapper objectMapper;
    @Value("${settings.default-file}")
    private String settingsFilePath;

    public Settings getSettings(Long idUser) throws IOException {
        Settings settingsByUserId = settingsRepository.getSettingsByUserId(idUser);
        if(settingsByUserId == null){
            settingsByUserId = settingsRepository.addDefaultSettings(createDefaultSettings(idUser));
        }
        return settingsByUserId;
    }

    public void saveSettings(Settings settings)  {
        settingsRepository.saveSettings(settings);
//        return getSettings(settings.getUserId());
    }

    private Settings createDefaultSettings(Long idUser) throws IOException {
        Settings settings = objectMapper.readValue(new File(settingsFilePath), Settings.class);
        settings.setUserId(idUser);
        settings.getGasConnectionSettings().setDisplayByOwnership(calculateDisplayByDesigner());
        settings.getGasConnectionSettings().setDisplayByOwnershipDesign(calculateDisplayByDesigner());
        return settings;
    }

    private DisplayByOwnershipEnum calculateDisplayByDesigner() {
        AppUser user = UserHelper.getPrincipal();
        if(user.isAdmin())
            return DisplayByOwnershipEnum.ALL;

        if (user.isEmployee())
            return DisplayByOwnershipEnum.COMPANY;

        if (user.isDesigner())
            return DisplayByOwnershipEnum.MINE;

        return null;
    }

}
