package focik.net.progasoffice.customers.domain;

import focik.net.progasoffice.customers.domain.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerFacade {

    public Customer getCustomer(int id) {
        Customer customer = new Customer();
        return customer;
    }
}
