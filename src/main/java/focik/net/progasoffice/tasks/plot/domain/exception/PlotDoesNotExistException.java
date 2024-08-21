package focik.net.progasoffice.tasks.plot.domain.exception;

import focik.net.progasoffice.common.exceptions.ObjectDoesNotExistException;

public class PlotDoesNotExistException extends ObjectDoesNotExistException {
    public PlotDoesNotExistException(Integer id) {
        super("Plot with id = " + id + " does not exist");
    }

}
