package focik.net.progasoffice.finance.invoice.infastructure.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Vat")
public class VatDbDto {
    @Id
    @Column(name = "id_vatu")
    private int id;
    @Column(name = "stawka")
    private String rate;
    @Column(name = "mnoznik")
    private BigDecimal multiplier;
}
