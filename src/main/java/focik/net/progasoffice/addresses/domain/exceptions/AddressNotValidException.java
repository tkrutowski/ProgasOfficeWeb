package focik.net.progasoffice.addresses.domain.exceptions;

import focik.net.progasoffice.common.exceptions.ObjectNotValidException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST)
public class AddressNotValidException extends ObjectNotValidException {
    public AddressNotValidException(String message) {
        super(message);
    }
}
