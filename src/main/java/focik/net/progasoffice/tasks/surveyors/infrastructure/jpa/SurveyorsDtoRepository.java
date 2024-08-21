package focik.net.progasoffice.tasks.surveyors.infrastructure.jpa;

import focik.net.progasoffice.tasks.surveyors.infrastructure.dto.SurveyorDbDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SurveyorsDtoRepository extends JpaRepository<SurveyorDbDto, Integer> {

    List<SurveyorDbDto> findAllByIsActive(Boolean isActive);

}
