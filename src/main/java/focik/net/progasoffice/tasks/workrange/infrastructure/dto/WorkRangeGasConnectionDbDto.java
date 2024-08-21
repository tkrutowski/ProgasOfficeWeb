package focik.net.progasoffice.tasks.workrange.infrastructure.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import focik.net.progasoffice.tasks.common.domain.model.GasCabinetProviderType;
import focik.net.progasoffice.tasks.common.domain.model.TaskType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Zakres_przylacze")
public class WorkRangeGasConnectionDbDto {

    @Id
    @Column(name = "id_zakresu")
    private Integer id;
    @Column(name = "id_zadania")
    private Integer idTask;
    @Column(name = "rodzaj_zadania")
    private TaskType taskType;
    @Column(name = "inne")
    private String info;
    @Column(name = "srednica")
    private Integer diameter;
    @Column(name = "dlugosc")
    private Double lengthWar;
    @Column(name = "material")
    private String material;
    @Column(name = "sdr")
    private String sdr;
    @Column(name = "dlugosc_proj")
    private Double lengthProj;
    @Column(name = "szafke_dostarcza")
    private GasCabinetProviderType gasCabinetProviderType;
    @Column(name = "szafka_data_odbioru", columnDefinition = "DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate gasCabinetPickupDate;
}
