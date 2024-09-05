package focik.net.progasoffice.finance.InvoiceCorrection.domain.model;

import focik.net.progasoffice.finance.invoice.domain.model.Vat;
import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceCorrectionItem {
    private Integer idCorrectionItem;
    private Integer idCorrectionNumber;//id_korekty_numer
    private Integer idCorrectionYear;//id_korekty_rok
    private String name;//nazwa_towaru
    private String pkwiu;
    private String unit;//jednostka_miary
    private Float quantity;//ilosc
    private BigDecimal priceNet;//cena_netto
    private BigDecimal amountNet;//wartosc_netto
    private BigDecimal amountVat;//wartosc_vat
    private BigDecimal amountGross;//wartosc_brutto
    private Vat vat;
}
