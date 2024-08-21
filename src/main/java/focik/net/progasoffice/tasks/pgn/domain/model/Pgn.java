package focik.net.progasoffice.tasks.pgn.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import focik.net.progasoffice.tasks.common.domain.model.TaskType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pgn {
    int id;
    int idTask;
    String pgnNumber;
    String applicationNumber;
    String recipient;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    LocalDate workDate;
    String info;
    TaskType taskType;
}
