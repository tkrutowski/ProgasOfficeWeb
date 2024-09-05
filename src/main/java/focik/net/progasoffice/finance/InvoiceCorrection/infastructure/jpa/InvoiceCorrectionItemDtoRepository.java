package focik.net.progasoffice.finance.InvoiceCorrection.infastructure.jpa;

import focik.net.progasoffice.finance.InvoiceCorrection.infastructure.dto.InvoiceCorrectionItemDbDto;
import org.springframework.data.jpa.repository.JpaRepository;

interface InvoiceCorrectionItemDtoRepository extends JpaRepository<InvoiceCorrectionItemDbDto, Integer> {

}
