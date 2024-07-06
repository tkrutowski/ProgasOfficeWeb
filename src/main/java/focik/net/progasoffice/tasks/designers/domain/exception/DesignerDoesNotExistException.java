package focik.net.progasoffice.tasks.designers.domain.exception;

import focik.net.progasoffice.common.exceptions.ObjectDoesNotExistException;

public class DesignerDoesNotExistException extends ObjectDoesNotExistException {
    public DesignerDoesNotExistException(Integer id) {
        super("Designer with id = " + id + " does not exist");
    }

}
