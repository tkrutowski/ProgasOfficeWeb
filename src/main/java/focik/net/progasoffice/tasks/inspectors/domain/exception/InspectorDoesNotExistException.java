package focik.net.progasoffice.tasks.inspectors.domain.exception;

import focik.net.progasoffice.common.exceptions.ObjectDoesNotExistException;

public class InspectorDoesNotExistException extends ObjectDoesNotExistException {
    public InspectorDoesNotExistException(Integer id) {
        super("Designer with id = " + id + " does not exist");
    }

}
