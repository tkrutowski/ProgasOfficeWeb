package focik.net.progasoffice.tasks.plot.infrastructure.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
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
@Table(name = "wlasciciel_dzialki")
public class PlotOwnerDbDto {

    @Id
    @Column(name = "id_wlasciciela")
    private Integer id;
    @Column(name = "nazwa")
    private String name;
}
