package focik.net.progasoffice.tasks.workrange.infrastructure.dto;

import focik.net.progasoffice.tasks.common.domain.model.GasPressureType;
import focik.net.progasoffice.tasks.common.domain.model.TaskType;
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
@Table(name = "Zakres_wlaczenie")
public class WorkRangeConnectionDbDto {

    @Id
    @Column(name = "id_zakresu")
    private Integer id;
    @Column(name = "id_zadania")
    private Integer idTask;
    @Column(name = "rodzaj_zadania")
    private TaskType taskType;
    @Column(name = "srednica")
    private Integer diameter;
    @Column(name = "material")
    private String material;
    @Column(name = "cisnienie")
    private GasPressureType pressure;
    @Column(name = "inne")
    private String info;
}
