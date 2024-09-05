package focik.net.progasoffice.finance.InvoiceCorrection.infastructure.jpa;

import focik.net.progasoffice.finance.InvoiceCorrection.domain.model.InvoiceCorrection;
import focik.net.progasoffice.finance.InvoiceCorrection.domain.port.secondary.InvoiceCorrectionRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class InvoiceCorrectionRepositoryAdapter implements InvoiceCorrectionRepository {

    private final InvoiceCorrectionDtoRepository invoiceCorrectionDtoRepository;
    private final ModelMapper modelMapper;


    @Override
    public List<InvoiceCorrection> findByInvoice(int idNumber, int idYear) {
        return invoiceCorrectionDtoRepository.findAllByIdInvoiceNumberAndIdInvoiceYear(idNumber,idYear)
                .stream()
                .peek(invoiceCorrectionDbDto -> {
                    // Konwersja PersistentBag na ArrayList
                    invoiceCorrectionDbDto.setItems(new ArrayList<>(invoiceCorrectionDbDto.getItems()));
                })
                .map(invoiceCorrectionDbDto -> modelMapper.map(invoiceCorrectionDbDto, InvoiceCorrection.class))
                .toList();
    }
}
