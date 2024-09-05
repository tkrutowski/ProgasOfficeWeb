package focik.net.progasoffice.finance.InvoiceCorrection.infastructure.jpa;

import focik.net.progasoffice.finance.InvoiceCorrection.infastructure.dto.InvoiceCorrectionDbDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

interface InvoiceCorrectionDtoRepository extends JpaRepository<InvoiceCorrectionDbDto, Integer> {

    List<InvoiceCorrectionDbDto> findAllByIdInvoiceNumberAndIdInvoiceYear(Integer idInvoiceNumber, Integer idInvoiceYear);
}
