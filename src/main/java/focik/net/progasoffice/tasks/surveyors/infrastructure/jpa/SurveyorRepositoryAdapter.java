package focik.net.progasoffice.tasks.surveyors.infrastructure.jpa;

import focik.net.progasoffice.share.ActiveStatus;
import focik.net.progasoffice.tasks.designers.domain.model.DesignerTraffic;
import focik.net.progasoffice.tasks.surveyors.domain.model.Surveyor;
import focik.net.progasoffice.tasks.surveyors.domain.port.secondary.SurveyorRepository;
import focik.net.progasoffice.tasks.surveyors.infrastructure.dto.SurveyorDbDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class SurveyorRepositoryAdapter implements SurveyorRepository {

    //TODO porawic na inspektora!!!!
    private final SurveyorsDtoRepository surveyorsDtoRepository;
    private final ModelMapper modelMapper;

    @Override
    public Optional<Surveyor> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<Surveyor> findAllByStatus(ActiveStatus status) {
        List<SurveyorDbDto> dtos = switch (status) {
            case ACTIVE -> surveyorsDtoRepository.findAllByIsActive(true);
            case INACTIVE -> surveyorsDtoRepository.findAllByIsActive(false);
            case ALL -> surveyorsDtoRepository.findAll();
        };

        return dtos.stream()
                .map(surveyorDbDto -> modelMapper.map(surveyorDbDto, Surveyor.class))
                .sorted(Comparator.comparing(Surveyor::getLastName))
                .collect(Collectors.toList());
    }

    @Override
    public List<Surveyor> findAll() {
        return List.of();
    }

}
