package focik.net.progasoffice.tasks.surveyors.domain;

import focik.net.progasoffice.share.ActiveStatus;
import focik.net.progasoffice.tasks.surveyors.domain.model.Surveyor;
import focik.net.progasoffice.tasks.surveyors.domain.port.primary.GetSurveyorUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SurveyorFacade implements GetSurveyorUseCase {

    private final SurveyorService surveyorService;
    @Override
    public Surveyor getSurveyorById(int id) {
        return surveyorService.getInspectorById(id);
    }

    @Override
    public List<Surveyor> getSurveyorsByActive(ActiveStatus status) {
        return surveyorService.getInspectorByActive(status);
    }
}
