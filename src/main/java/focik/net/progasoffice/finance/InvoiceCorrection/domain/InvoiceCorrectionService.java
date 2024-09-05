package focik.net.progasoffice.finance.InvoiceCorrection.domain;

import focik.net.progasoffice.finance.InvoiceCorrection.domain.model.InvoiceCorrection;
import focik.net.progasoffice.finance.InvoiceCorrection.domain.port.secondary.InvoiceCorrectionRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
class InvoiceCorrectionService {

    InvoiceCorrectionRepository correctionRepository;

    public List<InvoiceCorrection> findByTask(int idNumber, int idYear) {
        return  correctionRepository.findByInvoice(idNumber, idYear);
    }
}
