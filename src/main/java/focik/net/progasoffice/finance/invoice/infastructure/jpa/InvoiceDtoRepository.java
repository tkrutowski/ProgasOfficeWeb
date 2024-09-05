package focik.net.progasoffice.finance.invoice.infastructure.jpa;

import focik.net.progasoffice.finance.invoice.infastructure.dto.InvoiceDbDto;
import focik.net.progasoffice.tasks.common.domain.model.TaskType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

interface InvoiceDtoRepository extends JpaRepository<InvoiceDbDto, Integer> {

    List<InvoiceDbDto> findAllByIdTaskAndTaskType (Integer id, TaskType taskType);

}
