package focik.net.progasoffice.finance.InvoiceCorrection.domain.port.secondary;

import focik.net.progasoffice.finance.InvoiceCorrection.domain.model.InvoiceCorrection;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface InvoiceCorrectionRepository {

    List<InvoiceCorrection> findByInvoice(int idNumber, int idYear);

}
