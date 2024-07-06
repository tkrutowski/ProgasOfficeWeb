package focik.net.progasoffice.addresses.domain.exceptions;


import focik.net.progasoffice.common.exceptions.ObjectNotFoundException;

public class AddressNotFoundException extends ObjectNotFoundException {
    public AddressNotFoundException(Integer id) {
        super("Address with id = " + id + " does not exist");
    }
}
