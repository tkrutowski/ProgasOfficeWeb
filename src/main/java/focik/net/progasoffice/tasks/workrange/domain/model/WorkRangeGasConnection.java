package focik.net.progasoffice.tasks.workrange.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import focik.net.progasoffice.tasks.common.domain.model.GasCabinetProviderType;
import focik.net.progasoffice.tasks.common.domain.model.TaskType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkRangeGasConnection extends WorkRange {
    private Integer id;
    private Integer idTask;
    private TaskType taskType;
    private String info;
    private Integer diameter;
    private Double lengthWar;
    private String material;
    private String sdr;
    private Double lengthProj;
    private GasCabinetProviderType gasCabinetProviderType;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate gasCabinetPickupDate;
}
