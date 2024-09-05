package focik.net.progasoffice.finance.invoice.domain;

import focik.net.progasoffice.finance.invoice.domain.model.Invoice;
import focik.net.progasoffice.finance.invoice.domain.port.primary.GetInvoiceUseCase;
import focik.net.progasoffice.tasks.common.domain.model.TaskType;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class InvoiceFacade implements GetInvoiceUseCase {

    private final InvoiceService invoiceService;


    @Override
    public List<Invoice> getByTask(int idTask, TaskType taskType) {
        return invoiceService.findByTask(idTask, taskType);
    }
}
