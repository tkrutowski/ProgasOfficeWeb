package focik.net.progasoffice.tasks.surveyors.domain.port.secondary;

import focik.net.progasoffice.share.ActiveStatus;
import focik.net.progasoffice.tasks.surveyors.domain.model.Surveyor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface SurveyorRepository {

    Optional<Surveyor> findById(Integer id);

    List<Surveyor> findAllByStatus(ActiveStatus status);

    List<Surveyor> findAll();

}
