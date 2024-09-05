package focik.net.progasoffice.finance.InvoiceCorrection.api;

import focik.net.progasoffice.common.exceptions.ExceptionHandling;
import focik.net.progasoffice.finance.InvoiceCorrection.domain.model.InvoiceCorrection;
import focik.net.progasoffice.finance.InvoiceCorrection.domain.port.primary.GetInvoiceCorrectionUseCase;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Log4j2
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/finance/correction")
//@CrossOrigin
public class InvoiceCorrectionController extends ExceptionHandling {

    private final GetInvoiceCorrectionUseCase getInvoiceCorrectionUseCase;

    @GetMapping("/fv")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_FINANCE')")
    ResponseEntity<List<InvoiceCorrection>> getInvoicesCorrectionByInvoice(@RequestParam(name = "idNumber") Integer idNumber, @RequestParam(name = "idYear") Integer idYear) {
        List<InvoiceCorrection> corrections = getInvoiceCorrectionUseCase.getByInvoice(idNumber, idYear);
        return new ResponseEntity<>(corrections, HttpStatus.OK);
    }
}