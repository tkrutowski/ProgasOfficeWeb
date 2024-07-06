package focik.net.progasoffice.tasks.gasconnection.domain.exceptions;

import focik.net.progasoffice.common.exceptions.ObjectDoesNotExistException;

public class GasMainDoesNotExistException extends ObjectDoesNotExistException {
    public GasMainDoesNotExistException(Integer id) {
        super("GasMain with id = " + id + " does not exist");
    }
}
