package focik.net.progasoffice.addresses.domain;

import focik.net.progasoffice.addresses.domain.exceptions.AddressAlreadyExistsException;
import focik.net.progasoffice.addresses.domain.exceptions.AddressNotFoundException;
import focik.net.progasoffice.addresses.domain.exceptions.AddressNotValidException;
import focik.net.progasoffice.addresses.domain.port.AddressRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
class AddressService {

    //@Qualifier("inMemoryClientRepositoryAdapter")
    private final AddressRepository addressRepository;

    public Address addAddress(Address address) {
        if (address.getId()!=0) {
            Optional<Address> byId = addressRepository.findById(address.getId());

            if (byId.isPresent())
                throw new AddressAlreadyExistsException(address.getId());
        }
        return addressRepository.save(address);
    }

    public Address updateAddress(Address address) {
//        Optional<Address> byId = addressRepository.findById(address.getId());
//
        if (address.getId() == null || address.getId() <=0)
            throw new AddressNotValidException("Id can't be 0 or null: " + address.getId());
//        int i = 0;
        return addressRepository.save(address);
    }

    public Address getAddress(Integer id) {
        Optional<Address> byId = addressRepository.findById(id);

        if (byId.isEmpty())
            throw new AddressNotFoundException(id);

        return byId.get();
    }

    public void deleteAddress(Integer id) {
        addressRepository.deleteAddress(id);
    }
}
