package focik.net.progasoffice.tasks.workrange.infrastructure.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import focik.net.progasoffice.tasks.common.domain.model.GasCabinetProviderType;
import focik.net.progasoffice.tasks.common.domain.model.TaskType;
import focik.net.progasoffice.tasks.workrange.domain.model.GasStationType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Zakres_stacja")
public class WorkRangeGasStationDbDto {

    @Id
    @Column(name = "id_zakresu")
    private Integer id;
    @Column(name = "id_zadania")
    private Integer idTask;
    @Column(name = "rodzaj_zadania")
    private TaskType taskType;
    @Column(name = "inne")
    private String info;
    @Column(name = "przepustowosc")
    private Integer capacity;
    @Column(name = "ilosc")
    private String amount;
    @Column(name = "rodzaj_stacji")
    private GasStationType gasStationType;
}
