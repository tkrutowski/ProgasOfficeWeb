package focik.net.progasoffice.finance.invoice.infastructure.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import focik.net.progasoffice.customers.infrastructure.dto.CustomerDbDto;
import focik.net.progasoffice.finance.InvoiceCorrection.infastructure.dto.InvoiceCorrectionItemDbDto;
import focik.net.progasoffice.tasks.common.domain.model.TaskType;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Faktura")
@IdClass(InvoiceId.class)
public class InvoiceDbDto {

    @Id
    @Column(name = "id_faktury_numer")
    private Integer idInvoiceNumber;
    @Id
    @Column(name = "id_faktury_rok")
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
    @Column(name = "nr_umowy")
    private String contractNo;
    @Column(name = "data_wystawienia", columnDefinition = "DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate invoiceDate;//data wystawiena
    @Column(name = "rodzaj_zadania")
    private TaskType taskType;
    @Column(name = "id_zadania")
    private Integer idTask;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_faktury_numer") // Doda obcy klucz w tabeli pozycje
    @JoinColumn(name = "id_faktury_rok")   // Doda obcy klucz w tabeli pozycje
    private List<InvoiceItemDbDto> items;
}
