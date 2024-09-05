package focik.net.progasoffice.finance.invoice.domain.port.secondary;

import focik.net.progasoffice.finance.invoice.domain.model.Invoice;
import focik.net.progasoffice.tasks.common.domain.model.TaskType;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface InvoiceRepository {

    List<Invoice> findByTask(int idTask, TaskType taskType);
}
