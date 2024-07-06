package focik.net.progasoffice.tasks.pgn.domain.model;

import focik.net.progasoffice.tasks.common.TaskType;

import java.time.LocalDate;

public class Pgn {
    int id;
    int idTask;
    String pgnNo;
    String submissionNo;
    String submissionReceiver;
    LocalDate workDate;
    String info;
    TaskType taskType;
}
