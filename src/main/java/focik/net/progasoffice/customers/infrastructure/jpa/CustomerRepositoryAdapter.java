package focik.net.progasoffice.customers.infrastructure.jpa;

import focik.net.progasoffice.customers.domain.model.Customer;
import focik.net.progasoffice.customers.domain.port.secondary.CustomerRepository;
import focik.net.progasoffice.customers.infrastructure.dto.CustomerDbDto;
import focik.net.progasoffice.share.ActiveStatus;
import focik.net.progasoffice.tasks.designers.domain.model.Designer;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CustomerRepositoryAdapter implements CustomerRepository {

    private final CustomerDtoRepository customerDtoRepository;
    private final ModelMapper modelMapper;

    @Override
    public Optional<Customer> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<Customer> findAllByStatus(ActiveStatus status) {
        List<CustomerDbDto> dtos = new ArrayList<>();
        switch (status) {
            case ACTIVE:
                dtos = customerDtoRepository.findAllByIsActive(true);
                break;
            case INACTIVE:
                dtos = customerDtoRepository.findAllByIsActive(false);
                break;
            case ALL:
                dtos = customerDtoRepository.findAll();
                break;
        }

        return dtos.stream()
                .map(customerDbDto -> modelMapper.map(customerDbDto, Customer.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<Customer> findAll() {
        return List.of();
    }

}
