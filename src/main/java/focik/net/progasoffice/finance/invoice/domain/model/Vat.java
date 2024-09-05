package focik.net.progasoffice.finance.invoice.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vat {
    private int id;
    private String rate;//stawka
    private BigDecimal multiplier;//mnożnik
}
