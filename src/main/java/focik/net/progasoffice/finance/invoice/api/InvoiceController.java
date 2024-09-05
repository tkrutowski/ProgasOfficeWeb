package focik.net.progasoffice.finance.invoice.api;

import focik.net.progasoffice.common.exceptions.ExceptionHandling;
import focik.net.progasoffice.finance.invoice.domain.model.Invoice;
import focik.net.progasoffice.finance.invoice.domain.port.primary.GetInvoiceUseCase;
import focik.net.progasoffice.tasks.common.domain.model.TaskType;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Log4j2
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/finance/invoice")
//@CrossOrigin
public class InvoiceController extends ExceptionHandling {

    private final GetInvoiceUseCase getInvoiceUseCase;

    @GetMapping("/task")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_FINANCE')")
    ResponseEntity<List<Invoice>> getInvoicesByTask(@RequestParam(name = "idTask") Integer idTask, @RequestParam(name = "taskType", defaultValue = "GAS_CONNECTION") TaskType taskType) {
        List<Invoice> invoices = getInvoiceUseCase.getByTask(idTask, taskType);
        return new ResponseEntity<>(invoices, HttpStatus.OK);
    }
}