package focik.net.progasoffice.finance.InvoiceCorrection.domain.port.primary;

import focik.net.progasoffice.finance.InvoiceCorrection.domain.model.InvoiceCorrection;

import java.util.List;

public interface GetInvoiceCorrectionUseCase {
//    Invoice findById(Integer id);

    List<InvoiceCorrection> getByInvoice(int idNumber, int idYear);

}
