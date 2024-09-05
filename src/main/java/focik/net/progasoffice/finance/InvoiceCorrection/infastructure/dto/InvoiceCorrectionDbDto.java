package focik.net.progasoffice.finance.InvoiceCorrection.infastructure.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import focik.net.progasoffice.customers.infrastructure.dto.CustomerDbDto;
import focik.net.progasoffice.finance.invoice.infastructure.dto.PaymentMethodDbDto;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Korekta")
@IdClass(InvoiceCorrectionId.class)
public class InvoiceCorrectionDbDto {

    @Id
    @Column(name = "id_korekty_numer")
    private Integer idInvoiceCorrectionNumber;
    @Id
    @Column(name = "id_korekty_rok")
    private Integer idInvoiceCorrectionYear;
    @Column(name = "id_fv_nr")
    private Integer idInvoiceNumber;
    @Column(name = "id_fv_rok")
    private Integer idInvoiceYear;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_klienta")
    private CustomerDbDto customer;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_rodzaj_platnosci")
    private PaymentMethodDbDto paymentMethod;
    @Column(name = "data_sprzedazy", columnDefinition = "DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate sellDate;
    @Column(name = "data_platnosci", columnDefinition = "DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate paymentDate;//termin zapłaty
    @Column(name = "wartosc_netto")
    private BigDecimal amountNet;
    @Column(name = "wartosc_vat")
    private BigDecimal amountVat;
    @Column(name = "wartosc_brutto")
    private BigDecimal amountGross;
    @Column(name = "czy_zaplacona")
    private Boolean paid;
    @Column(name = "data_wystawienia", columnDefinition = "DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate invoiceDate;//data wystawiena
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_korekty_numer") // Doda obcy klucz w tabeli pozycje
    @JoinColumn(name = "id_korekty_rok")   // Doda obcy klucz w tabeli pozycje
    private List<InvoiceCorrectionItemDbDto> items;
}
