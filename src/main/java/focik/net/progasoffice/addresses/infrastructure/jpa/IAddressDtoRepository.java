package focik.net.progasoffice.addresses.infrastructure.jpa;


import focik.net.progasoffice.addresses.infrastructure.dto.AddressDbDto;
import org.springframework.data.repository.CrudRepository;

interface IAddressDtoRepository extends CrudRepository<AddressDbDto, Integer> {
}
