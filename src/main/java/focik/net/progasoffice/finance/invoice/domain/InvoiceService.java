package focik.net.progasoffice.finance.invoice.domain;

import focik.net.progasoffice.finance.invoice.domain.model.Invoice;
import focik.net.progasoffice.finance.invoice.domain.port.secondary.InvoiceRepository;
import focik.net.progasoffice.tasks.common.domain.model.TaskType;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
class InvoiceService {

    InvoiceRepository invoiceRepository;

    public List<Invoice> findByTask(int idTask, TaskType taskType) {
        List<Invoice> invoiceList = invoiceRepository.findByTask(idTask, taskType);

        return invoiceList;
    }
}
