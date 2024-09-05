package focik.net.progasoffice.finance.invoice.infastructure.jpa;

import focik.net.progasoffice.finance.invoice.domain.model.Invoice;
import focik.net.progasoffice.finance.invoice.domain.port.secondary.InvoiceRepository;
import focik.net.progasoffice.tasks.common.domain.model.TaskType;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class InvoiceRepositoryAdapter implements InvoiceRepository {

    private final InvoiceDtoRepository invoiceDtoRepository;
    private final ModelMapper modelMapper;


    @Override
    public List<Invoice> findByTask(int idTask, TaskType taskType) {
        return invoiceDtoRepository.findAllByIdTaskAndTaskType(idTask, taskType)
                .stream()
                .peek(invoiceDbDto -> {
                    // Konwersja PersistentBag na ArrayList
                    invoiceDbDto.setItems(new ArrayList<>(invoiceDbDto.getItems()));
                })
                .map(invoiceDbDto -> modelMapper.map(invoiceDbDto, Invoice.class))
                .toList();
    }
}
