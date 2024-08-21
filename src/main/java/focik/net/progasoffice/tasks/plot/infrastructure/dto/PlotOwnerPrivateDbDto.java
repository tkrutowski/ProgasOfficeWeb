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
@Table(name = "wlasciciel_prywatny_dzialki")
public class PlotOwnerPrivateDbDto {

    @Id
    @Column(name = "id_wlasciciela")
    private Integer id;
    @Column(name = "id_dzialki")
    private Integer idPlot;
    @Column(name = "imie")
    private String name;
    @Column(name = "nazwisko")
    private String lastName;
    @Column(name = "udzial")
    private Integer share;
    @Column(name = "data_zlozenia", columnDefinition = "DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate submissionDate;
    @Column(name = "data_otrzymania", columnDefinition = "DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate receiptDate;
    @Column(name = "data_zlozenia_1", columnDefinition = "DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate submissionDate1;
    @Column(name = "data_otrzymania_1", columnDefinition = "DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate receiptDate1;
    @Column(name = "info_1")
    private String info1;
    @Column(name = "data_zlozenia_2", columnDefinition = "DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate submissionDate2;
    @Column(name = "data_otrzymania_2", columnDefinition = "DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate receiptDate2;
    @Column(name = "info_2")
    private String info2;
}
