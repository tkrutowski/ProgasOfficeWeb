package focik.net.progasoffice.tasks.plot.infrastructure.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import focik.net.progasoffice.addresses.infrastructure.dto.AddressDbDto;
import focik.net.progasoffice.tasks.common.domain.model.TaskType;
import focik.net.progasoffice.tasks.plot.domain.model.PlotOwner;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Dzialka")
public class PlotDbDto {

    @Id
    @Column(name = "id_dzialki")
    private Integer id;
    @Column(name = "id_zadania")
    private Integer idTask;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_wlasciciela")
    private PlotOwnerDbDto plotOwner;
    @Column(name = "nr_dzialki")
    private String plotNumber;
    @Column(name = "data_zlozenia", columnDefinition = "DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate submissionDate;
    @Column(name = "data_otrzymania", columnDefinition = "DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate receiptDate;
    @Column(name = "data_zlozenia_zajecie_pasa", columnDefinition = "DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate laneOccupationSubmissionDate;
    @Column(name = "data_otrzymania_zajecie_pasa", columnDefinition = "DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate laneOccupationReceiptDate;
    @Column(name = "data_odbioru_pasa", columnDefinition = "DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate laneReceiptDate;
    @Column(name = "inne")
    private String info;
    @Column(name = "rodzaj_zadania")
    private TaskType taskType;
    @Column(name = "podmiot_przylaczeniowy")
    private Boolean connectionEntity;
    @Column(name = "data_przygotowania_zajecie_pasa", columnDefinition = "DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate laneOccupationPreparationDate;
    @Column(name = "data_zajecie_pasa_od", columnDefinition = "DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate laneOccupationStartDate;
    @Column(name = "data_zajecie_pasa_do", columnDefinition = "DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate laneOccupationEndDate;
}
