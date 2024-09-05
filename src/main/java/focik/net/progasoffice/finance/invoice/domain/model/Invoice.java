package focik.net.progasoffice.finance.invoice.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import focik.net.progasoffice.customers.domain.model.Customer;
import focik.net.progasoffice.tasks.common.domain.model.TaskType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Invoice {
    private Integer idInvoiceNumber;//id_faktury_numer
    private Integer idInvoiceYear;//id_faktury_rok
    private Customer customer;
    private PaymentMethod paymentMethod;//id_rodzaj_platnosci
    private LocalDate sellDate;//data_sprzedazy
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate paymentDate;//termin zapłaty
    private BigDecimal amountNet;//wartosc_netto
    private BigDecimal amountVat;//wartosc_vat
    private BigDecimal amountGross;//wartosc_brutto
    private Boolean paid;//czy_zaplacona
    private String contractNo;//nr_umowy
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate invoiceDate;//data wystawiena
    private TaskType taskType;
    private Integer idTask;
    private List<InvoiceItem> invoiceItems;

}
