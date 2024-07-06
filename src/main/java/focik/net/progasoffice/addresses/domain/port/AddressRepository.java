package focik.net.progasoffice.addresses.domain.port;

import focik.net.progasoffice.addresses.domain.Address;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface AddressRepository {

    Address save(Address address);

    Optional<Address> findById(Integer id);

    void deleteAddress(Integer id);
}
