package focik.net.progasoffice.finance.InvoiceCorrection.domain;

import focik.net.progasoffice.finance.InvoiceCorrection.domain.model.InvoiceCorrection;
import focik.net.progasoffice.finance.InvoiceCorrection.domain.port.primary.GetInvoiceCorrectionUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class InvoiceCorrectionFacade implements GetInvoiceCorrectionUseCase {

    private final InvoiceCorrectionService correctionService;

    @Override
    public List<InvoiceCorrection> getByInvoice(int idNumber, int idYear) {
        return correctionService.findByTask(idNumber, idYear);
    }
}
