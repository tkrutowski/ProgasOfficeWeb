package focik.net.progasoffice.addresses.domain.port;

import org.springframework.stereotype.Component;
import focik.net.progasoffice.addresses.domain.Address;
import java.util.Optional;

@Component
public interface AddressRepository {

    Address save(Address address);

    Optional<Address> findById(Long id);

    void deleteAddress(Long id);
}
