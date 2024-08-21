package focik.net.progasoffice.customers.domain.port.primary;

import focik.net.progasoffice.customers.domain.model.Customer;
import focik.net.progasoffice.share.ActiveStatus;
import focik.net.progasoffice.tasks.designers.domain.model.Designer;

import java.util.List;

public interface GetCustomerUseCase {
    Customer getCustomerById(int id);

    List<Customer> getCustomerByActive(ActiveStatus status);

}
