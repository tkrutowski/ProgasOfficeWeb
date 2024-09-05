package focik.net.progasoffice.finance.InvoiceCorrection.infastructure.dto;

import focik.net.progasoffice.finance.invoice.infastructure.dto.VatDbDto;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "pozycja_na_korekcie")
public class InvoiceCorrectionItemDbDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pozycji")
    private Integer idCorrectionItem;
    @Column(name = "id_korekty_numer")
    private Integer idCorrectionNumber;
    @Column(name = "id_korekty_rok")
    private Integer idCorrectionYear;
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
