package focik.net.progasoffice.addresses.domain;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AddressFacade {

    private final AddressService addressService;

    public Address addAddress(Address address) {
        return addressService.addAddress(address);
    }

    public Address updateAddress(Address address) {
        return addressService.updateAddress(address);
    }

    public Address getAddress(Long id) {
        return addressService.getAddress(id);
    }

    public void deleteAddress(Long id){
        addressService.deleteAddress(id);
    }

}
