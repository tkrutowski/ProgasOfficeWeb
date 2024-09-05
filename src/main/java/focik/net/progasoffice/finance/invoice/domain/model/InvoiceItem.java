package focik.net.progasoffice.finance.invoice.domain.model;

import focik.net.progasoffice.finance.invoice.infastructure.dto.VatDbDto;
import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceItem {
    private Integer idInvoiceItem;
    private Integer idInvoiceNumber;//id_faktury_numer
    private Integer idInvoiceYear;//id_faktury_rok
    private String name;
    private String pkwiu;
    private String unitunit;//jednostka_miary
    private Float quantity;//ilosc
    private BigDecimal priceNet;//cena_netto
    private BigDecimal amountNet;//wartosc_netto
    private BigDecimal amountVat;//wartosc_vat
    private BigDecimal amountGross;//wartosc_brutto
    private VatDbDto vat;
}
