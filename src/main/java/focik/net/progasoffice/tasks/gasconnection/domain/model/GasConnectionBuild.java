package focik.net.progasoffice.tasks.gasconnection.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import focik.net.progasoffice.tasks.gasdistributions.domain.model.GasDistribution;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GasConnectionBuild {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate substationNotificationSubmissionDate;//zaw_rozdzielni_data_zlozenia

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate surveyingSketchesDate;//geodezja_szkice
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate surveyingInventoryDate;//geodezja_inwentaryzacja

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate realizationStartDate;//realizacja_data_rozpoczecia
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate realizationEndDate;//realizacja_data_zakonczenia

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate wsgTechnicalAcceptanceDate;//odbior_wsg_techniczny
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate wsgFinalAcceptanceSubmissionDate;//odbior_wsg_koncowy_data_wyslania
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate wsgFinalAcceptanceDate;//odbior_wsg_koncowy
    private String technicalAcceptanceProtocolNo;//nr_protokolu_odbioru_tech
    private String gasPipelineInventoryNumber;//nr_inwentarzowy_gazociagu
    private Float gasConnectionRealLength;//dl_przyl_rzecz
    private String wsgInfo;//odbior_wsg_uwagi
}
