package focik.net.progasoffice.addresses.infrastructure.inMemory;

import focik.net.progasoffice.addresses.domain.Address;
import focik.net.progasoffice.addresses.domain.port.AddressRepository;
import focik.net.progasoffice.addresses.infrastructure.dto.AddressDbDto;
import lombok.extern.java.Log;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Profile({"test"})
@Log
public class InMemoryAddressRepositoryAdapter implements AddressRepository {

    private final ModelMapper mapper = new ModelMapper();

    @Override
    public Address save(Address address) {

        if (address.getId() == null || address.getId() == 0) {
            return add(address);
        }
        else {
            return update(address);
        }
    }

    @Override
    public Optional<Address> findById(Integer id) {
        return Optional.ofNullable(DataBaseAddress.getAddressHashMap().get(id))
                .map(dbDto -> mapper.map(dbDto, Address.class));
    }

    @Override
    public void deleteAddress(Integer id) {
        DataBaseAddress.getAddressHashMap().remove(id);
    }

    private Address add(Address address) {
        AddressDbDto addressDbDto = mapper.map(address, AddressDbDto.class);
        log.info("Try add into inMemoryDb address: " + addressDbDto.toString());
        if (addressDbDto == null)
            throw new NullPointerException("Address cannot be null");
        Integer id = DataBaseAddress.getAddressHashMap()
                .keySet()
                .stream()
                .reduce(Integer::max)
                .orElse(Integer.valueOf("0")) + 1;

        addressDbDto.setId(id);
        DataBaseAddress.getAddressHashMap().put(id, addressDbDto);
        log.info("Succssec id = " + id);
        AddressDbDto dbDto = DataBaseAddress.getAddressHashMap().get(id);
        return mapper.map(dbDto, Address.class);
    }

    private Address update(Address address) {
        AddressDbDto addressDbDto = mapper.map(address, AddressDbDto.class);
        log.info("Try update into inMemoryDb address: " + addressDbDto.toString());
        if (addressDbDto == null)
            throw new NullPointerException("Address cannot be null");

        DataBaseAddress.getAddressHashMap().put(address.getId(), addressDbDto);
        log.info("Succssec id = " + address.getId());
        AddressDbDto dbDto = DataBaseAddress.getAddressHashMap().get(address.getId());
        return mapper.map(dbDto, Address.class);
    }
}
