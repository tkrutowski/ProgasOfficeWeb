package focik.net.progasoffice.tasks.finance.infrastructure.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import focik.net.progasoffice.tasks.common.domain.model.TaskType;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Koszt")
public class CostDbDto {
    @Id
    @Column(name = "id_kosztu")
    private int id;
    @Column(name = "id_zadania")
    private int idTask;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_nazwa_kosztu")
    private CostTypeDbDto costType;
    @Column(name = "data_zapl", columnDefinition = "DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate paymentDate;
    @Column(name = "kwota")
    private BigDecimal amount;
    @Column(name = "rodzaj_zadania")
    private TaskType taskType;
    @Column(name = "inne")
    private String description;
}
