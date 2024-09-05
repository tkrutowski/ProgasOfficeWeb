package focik.net.progasoffice.finance.invoice.infastructure.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "rodzaj_platnosci")
public class PaymentMethodDbDto {
    @Id
    @Column(name = "id_rodzaj_platnosci")
    private int id;
    @Column(name = "nazwa")
    private String name;
}
