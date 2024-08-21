package focik.net.progasoffice.tasks.workrange.domain.exception;

import focik.net.progasoffice.common.exceptions.ObjectDoesNotExistException;

public class WorkRangeDoesNotExistException extends ObjectDoesNotExistException {
    public WorkRangeDoesNotExistException(Integer id) {
        super("WorkRange with id = " + id + " does not exist");
    }

}
