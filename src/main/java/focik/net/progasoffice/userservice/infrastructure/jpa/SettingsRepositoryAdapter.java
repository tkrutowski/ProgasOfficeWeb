package focik.net.progasoffice.userservice.infrastructure.jpa;

import focik.net.progasoffice.userservice.domain.model.GasConnectionSettings;
import focik.net.progasoffice.userservice.domain.model.Settings;
import focik.net.progasoffice.userservice.domain.port.secondary.SettingsRepository;
import focik.net.progasoffice.userservice.infrastructure.dto.ColumnDesignViewDbDto;
import focik.net.progasoffice.userservice.infrastructure.dto.ColumnViewDbDto;
import focik.net.progasoffice.userservice.infrastructure.dto.GasConnectionSettingsDbDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class SettingsRepositoryAdapter implements SettingsRepository {
    private final SettingsGasConnectionDtoRepository settingsGasConnectionDtoRepository;
    private final ModelMapper modelMapper;

    @Override
    public Settings addDefaultSettings(Settings settings) {
        GasConnectionSettingsDbDto dbDto = GasConnectionSettingsDbDto.builder()
                .userId(settings.getUserId())
                .sortColumn(settings.getGasConnectionSettings().getSortColumn())
                .sortDirection(settings.getGasConnectionSettings().getSortDirection())
                .rowsNumber(settings.getGasConnectionSettings().getRowsNumber())
                .displayStatus(settings.getGasConnectionSettings().getDisplayStatus())
                .displayByOwnership(settings.getGasConnectionSettings().getDisplayByOwnership())
                .colorCompleted(settings.getGasConnectionSettings().getColorCompleted())
                .colorBeforeDeadline(settings.getGasConnectionSettings().getColorBeforeDeadline())
                .daysBeforeFinishDeadline(settings.getGasConnectionSettings().getDaysBeforeFinishDeadline())
                .daysBeforeProjectDeadline(settings.getGasConnectionSettings().getDaysBeforeProjectDeadline())
                .colorOverdue(settings.getGasConnectionSettings().getColorOverdue())
                .colorSubmission(settings.getGasConnectionSettings().getColorSubmission())
                .colorReceipt(settings.getGasConnectionSettings().getColorReceipt())
                .colorFvReady(settings.getGasConnectionSettings().getColorFvReady())
                .gasConnectionColumns(settings.getGasConnectionSettings().getGasConnectionColumns()
                        .stream()
                        .map(columnView -> modelMapper.map(columnView, ColumnViewDbDto.class))
                        .collect(Collectors.toSet()))
                //design
                .sortColumnDesign(settings.getGasConnectionSettings().getSortColumnDesign())
                .sortDirectionDesign(settings.getGasConnectionSettings().getSortDirectionDesign())
                .rowsNumberDesign(settings.getGasConnectionSettings().getRowsNumberDesign())
                .displayStatusDesign(settings.getGasConnectionSettings().getDisplayStatusDesign())
                .displayByOwnershipDesign(settings.getGasConnectionSettings().getDisplayByOwnershipDesign())
                .gasConnectionColumnsDesign(settings.getGasConnectionSettings().getGasConnectionColumnsDesign()
                        .stream()
                        .map(columnView -> modelMapper.map(columnView, ColumnDesignViewDbDto.class))
                        .collect(Collectors.toSet()))
                .build();

        GasConnectionSettingsDbDto saved = settingsGasConnectionDtoRepository.save(dbDto);
        return modelMapper.map(saved, Settings.class);
    }

    @Override
    public Settings getSettingsByUserId(Long idUser) {
        Optional<GasConnectionSettingsDbDto> dbDto = settingsGasConnectionDtoRepository.findById(idUser);
        GasConnectionSettings gasConnectionSettings = dbDto.map(gasConnectionSettingsDbDto -> modelMapper.map(gasConnectionSettingsDbDto, GasConnectionSettings.class)).orElse(null);
        return Objects.isNull(gasConnectionSettings) ? null : new Settings(idUser, gasConnectionSettings);
    }

    @Override
    @Transactional
    public void saveSettings(Settings settings) {

        settingsGasConnectionDtoRepository.deleteAllByUserId(settings.getUserId());

        GasConnectionSettingsDbDto gasConnectionSettingsDbDto = modelMapper.map(settings.getGasConnectionSettings(), GasConnectionSettingsDbDto.class);
        gasConnectionSettingsDbDto.setUserId(settings.getUserId());
        GasConnectionSettingsDbDto saved = settingsGasConnectionDtoRepository.save(gasConnectionSettingsDbDto);
//        GasConnectionSettings gasConnectionSettings = modelMapper.map(gasConnectionSettingsDbDto, GasConnectionSettings.class);
//        System.out.println();
//        return gasConnectionSettings;
    }
}
