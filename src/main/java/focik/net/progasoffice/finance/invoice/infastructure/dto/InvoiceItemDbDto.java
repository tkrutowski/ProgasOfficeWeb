package focik.net.progasoffice.finance.invoice.infastructure.dto;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "pozycja_na_fakturze")
public class InvoiceItemDbDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pozycji")
    private Integer idInvoiceItem;
    @Column(name = "id_faktury_numer")
    private Integer idInvoiceNumber;
    @Column(name = "id_faktury_rok")
    private Integer idInvoiceYear;
    @Column(name = "nazwa_towaru")
    private String name;
    @Column(name = "pkwiu")
    private String pkwiu;
    @Column(name = "jednostka_miary")
    private String unit;
    @Column(name = "ilosc")
    private Float quantity;
    @Column(name = "cena_netto")
    private BigDecimal priceNet;
    @Column(name = "wartosc_netto")
    private BigDecimal amountNet;
    @Column(name = "wartosc_vat")
    private BigDecimal amountVat;
    @Column(name = "wartosc_brutto")
    private BigDecimal amountGross;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_vat")
    private VatDbDto vat;
}
