package focik.net.progasoffice.finance.invoice.infastructure.jpa;

import focik.net.progasoffice.finance.invoice.infastructure.dto.InvoiceItemDbDto;
import org.springframework.data.jpa.repository.JpaRepository;

interface InvoiceItemDtoRepository extends JpaRepository<InvoiceItemDbDto, Integer> {

}
