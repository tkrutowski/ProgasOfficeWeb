package focik.net.progasoffice.tasks.surveyors.domain;

import focik.net.progasoffice.share.ActiveStatus;
import focik.net.progasoffice.tasks.surveyors.domain.exception.SurveyorDoesNotExistException;
import focik.net.progasoffice.tasks.surveyors.domain.model.Surveyor;
import focik.net.progasoffice.tasks.surveyors.domain.port.secondary.SurveyorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class SurveyorService {
    private final SurveyorRepository surveyorRepository;


    public Surveyor getInspectorById(int id) {
        return surveyorRepository.findById(id).orElseThrow(() -> new SurveyorDoesNotExistException(id));
    }

    public List<Surveyor> getInspectorByActive(ActiveStatus status) {
        return surveyorRepository.findAllByStatus(status);
    }

}
