package focik.net.progasoffice.customers.infrastructure.jpa;

import focik.net.progasoffice.customers.infrastructure.dto.CustomerDbDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerDtoRepository extends JpaRepository<CustomerDbDto, Integer> {

    List<CustomerDbDto> findAllByIsActive(Boolean isActive);
}
