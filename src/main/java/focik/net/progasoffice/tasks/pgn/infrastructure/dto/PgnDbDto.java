package focik.net.progasoffice.tasks.pgn.infrastructure.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import focik.net.progasoffice.tasks.common.domain.model.TaskType;
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
@Table(name = "pgn")
public class PgnDbDto {

    @Id
    @Column(name = "id_pgn")
    private Integer id;
    @Column(name = "id_zadania")
    private Integer idTask;
    @Column(name = "nr_pgn")
    private String pgnNumber;
    @Column(name = "nr_zgloszenia")
    private String applicationNumber;
    @Column(name = "przyjmujacy")
    private String recipient;
    @Column(name = "data_prac", columnDefinition = "DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate workDate;
    @Column(name = "inne")
    private String info;
    @Column(name = "rodzaj_zadania")
    private TaskType taskType;
}
