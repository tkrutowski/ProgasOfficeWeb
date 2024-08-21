package focik.net.progasoffice.tasks.workrange.domain.model;

import focik.net.progasoffice.tasks.common.domain.model.TaskType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkRangeGasStation extends WorkRange {
    private Integer id;
    private Integer idTask;
    private TaskType taskType;
    private String info;
    private Integer capacity;
    private Integer amount;
    private GasStationType stationType;
}
