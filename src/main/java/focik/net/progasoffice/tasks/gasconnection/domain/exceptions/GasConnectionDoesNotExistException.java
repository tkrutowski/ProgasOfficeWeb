package focik.net.progasoffice.tasks.gasconnection.domain.exceptions;

import focik.net.progasoffice.common.exceptions.ObjectDoesNotExistException;

public class GasConnectionDoesNotExistException extends ObjectDoesNotExistException {
    public GasConnectionDoesNotExistException(Integer id) {
        super("GasConnection with id = " + id + " does not exist");
    }

}
