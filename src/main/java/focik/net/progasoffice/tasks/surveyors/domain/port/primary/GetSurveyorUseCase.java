package focik.net.progasoffice.tasks.surveyors.domain.port.primary;

import focik.net.progasoffice.share.ActiveStatus;
import focik.net.progasoffice.tasks.surveyors.domain.model.Surveyor;

import java.util.List;

public interface GetSurveyorUseCase {
    Surveyor getSurveyorById(int id);

    List<Surveyor> getSurveyorsByActive(ActiveStatus status);

}
