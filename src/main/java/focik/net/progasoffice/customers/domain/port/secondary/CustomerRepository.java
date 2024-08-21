package focik.net.progasoffice.customers.domain.port.secondary;

import focik.net.progasoffice.customers.domain.model.Customer;
import focik.net.progasoffice.share.ActiveStatus;
import focik.net.progasoffice.tasks.designers.domain.model.Designer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface CustomerRepository {

    Optional<Customer> findById(Integer id);

    List<Customer> findAllByStatus(ActiveStatus status);

    List<Customer> findAll();

}
