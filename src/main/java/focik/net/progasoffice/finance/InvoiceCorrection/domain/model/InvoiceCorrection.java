package focik.net.progasoffice.finance.InvoiceCorrection.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import focik.net.progasoffice.customers.domain.model.Customer;
import focik.net.progasoffice.finance.invoice.domain.model.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceCorrection {

    private Integer idInvoiceCorrectionNumber;
    private Integer idInvoiceCorrectionYear;
    private Integer idInvoiceNumber;
    private Integer idInvoiceYear;
    private Customer customer;
    private PaymentMethod paymentMethod;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate sellDate;//data_sprzedazy
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate paymentDate;//data_platnosci
    private BigDecimal amountNet;//wartosc_netto
    private BigDecimal amountVat;//wartosc_vat
    private BigDecimal amountGross;//wartosc_brutto
    private Boolean paid;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate invoiceDate;//data wystawiena
    private Set<InvoiceCorrectionItem> invoiceCorrectionItems;
}
