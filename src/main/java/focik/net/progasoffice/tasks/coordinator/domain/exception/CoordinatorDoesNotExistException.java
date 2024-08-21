package focik.net.progasoffice.tasks.coordinator.domain.exception;

import focik.net.progasoffice.common.exceptions.ObjectDoesNotExistException;

public class CoordinatorDoesNotExistException extends ObjectDoesNotExistException {
    public CoordinatorDoesNotExistException(Integer id) {
        super("Coordinator with id = " + id + " does not exist");
    }

}
