package focik.net.progasoffice.tasks.workrange.domain.model;

import focik.net.progasoffice.tasks.common.domain.model.GasPressureType;
import focik.net.progasoffice.tasks.common.domain.model.TaskType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkRangeConnection extends WorkRange {

    private Integer id;
    private Integer idTask;
    private TaskType taskType;
    private Integer diameter;
    private String material;
    private GasPressureType pressure;
    private String info;
}
