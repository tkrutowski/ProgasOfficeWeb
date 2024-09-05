package focik.net.progasoffice.finance.invoice.domain.port.primary;

import focik.net.progasoffice.finance.invoice.domain.model.Invoice;
import focik.net.progasoffice.tasks.common.domain.model.TaskType;

import java.util.List;

public interface GetInvoiceUseCase {
//    Invoice findById(Integer id);

    List<Invoice> getByTask(int idTask, TaskType taskType);

}
