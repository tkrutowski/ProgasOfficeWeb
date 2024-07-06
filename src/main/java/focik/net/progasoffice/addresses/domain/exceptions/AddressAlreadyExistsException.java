package focik.net.progasoffice.addresses.domain.exceptions;


import focik.net.progasoffice.common.exceptions.ObjectAlreadyExistException;

public class AddressAlreadyExistsException extends ObjectAlreadyExistException {
    public AddressAlreadyExistsException(Integer id) {
        super("Address with id: " + id + " already exists.");
    }
}
