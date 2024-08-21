package focik.net.progasoffice.tasks.surveyors.domain.exception;

import focik.net.progasoffice.common.exceptions.ObjectDoesNotExistException;

public class SurveyorDoesNotExistException extends ObjectDoesNotExistException {
    public SurveyorDoesNotExistException(Integer id) {
        super("Surveyor with id = " + id + " does not exist");
    }

}
