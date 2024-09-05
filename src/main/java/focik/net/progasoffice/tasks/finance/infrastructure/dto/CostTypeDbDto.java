package focik.net.progasoffice.tasks.finance.infrastructure.dto;

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
@Table(name = "Nazwa_kosztu")
public class CostTypeDbDto {
    @Id
    @Column(name = "id_nazwa_kosztu")
    private int id;
    @Column(name = "nazwa")
    private String name;
}
