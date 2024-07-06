package focik.net.progasoffice.addresses.infrastructure.jpa;

import focik.net.progasoffice.addresses.domain.Address;
import focik.net.progasoffice.addresses.domain.port.AddressRepository;
import focik.net.progasoffice.addresses.infrastructure.dto.AddressDbDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
class AddressRepositoryAdapter implements AddressRepository {

    IAddressDtoRepository addressDtoRepository;
    JpaMapper mapper;

    @Override
    public Address save(Address address) {
        AddressDbDto save = addressDtoRepository.save(mapper.toDto(address));
        return mapper.toDomain(save);
    }

    @Override
    public Optional<Address> findById(Integer id) {
        if (id == null)
            return Optional.empty();

        Optional<AddressDbDto> byId = addressDtoRepository.findById(id);

        if (byId.isPresent())
            return Optional.of(mapper.toDomain(byId.get()));

        return Optional.empty();
    }

    @Override
    public void deleteAddress(Integer id) {
        addressDtoRepository.deleteById(id);
    }
}
