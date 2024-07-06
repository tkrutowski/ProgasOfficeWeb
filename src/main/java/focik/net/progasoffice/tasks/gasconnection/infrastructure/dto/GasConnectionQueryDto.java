package focik.net.progasoffice.tasks.gasconnection.infrastructure.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "przylacze_view_java")
public class GasConnectionQueryDto {
    @Id
    @Column(name = "id_przylacza")
    private Integer idTask;

    @Column(name = "Projektant_razem")
    private String designerFullName;

    @Column(name = "Koordynator_razem")
    private String coordinatorFullName;

    @Column(name = "Klient_razem")
    private String customerFullName;

    @Column(name = "gmina")
    private String commune;

    @Column(name = "miasto")
    private String city;

    @Column(name = "ulica_dzialka")
    private String street;

    @Column(name = "nr_zadania")
    private String taskNo;

    @Column(name = "nr_warunkow")
    private String conditionNo;

    @Column(name = "nr_umowy")
    private String contractNo;

    @Column(name = "data_umowy", columnDefinition = "DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate contractDate;

    @Column(name = "termin_wykonania", columnDefinition = "DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate finishDeadline;

    @Column(name = "tel")
    private String customerPhone;

    @Column(name = "czy_zakonczone")
    private Boolean isFinished;

    @Column(name = "czy_PGN")
    private Boolean isPGN;

    @Column(name = "mapa_data_zlozenia", columnDefinition = "DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate mapSubmissionDate;

    @Column(name = "mapa_data_otrzymania", columnDefinition = "DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate mapReceiptDate;

    @Column(name = "wypis_data_zlozenia", columnDefinition = "DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate extractSubmissionDate;

    @Column(name = "wypis_data_otrzymania", columnDefinition = "DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate extractReceiptDate;

    @Column(name = "zudp_data_zlozenia", columnDefinition = "DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate zupdSubmissionDate;

    @Column(name = "zudp_data_otrzymania", columnDefinition = "DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate zudpReceiptDate;

    @Column(name = "zaklad_komunalny_data_zlozenia", columnDefinition = "DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate utilityCompanySubmissionDate;

    @Column(name = "zaklad_komunalny_data_otrzymania", columnDefinition = "DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate utilityCompanyReceiptDate;

    @Column(name = "uzgodnienie_wsg_data_zlozenia", columnDefinition = "DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate agreementSubmissionDate;

    @Column(name = "uzgodnienie_wsg_data_otrzymania", columnDefinition = "DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate agreementReceiptDate;

    @Column(name = "zaw_rozdzielni_data_zlozenia", columnDefinition = "DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate substationNotificationSubmissionDate;

    @Column(name = "realizacja_data_rozpoczecia", columnDefinition = "DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate realizationStartDate;

    @Column(name = "realizacja_data_zakonczenia", columnDefinition = "DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate realizationEndDate;

    @Column(name = "geodezja_szkice", columnDefinition = "DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate surveyingSketchesDate;

    @Column(name = "geodezja_inwentaryzacja", columnDefinition = "DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate surveyingInventoryDate;

    @Column(name = "odbior_wsg_techniczny", columnDefinition = "DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate wsgTechnicalAcceptanceDate;

    @Column(name = "wartosc_projektu", columnDefinition = "DATE")
    private BigDecimal projectValue;

    @Column(name = "wartosc_wykonawstwa", columnDefinition = "DATE")
    private BigDecimal constructionValue;

    @Column(name = "wartosc_zadania", columnDefinition = "DATE")
    private BigDecimal taskValue;

    @Column(name = "termin_projektu", columnDefinition = "DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate projectDeadline;

    @Column(name = "zlecenie_projektu_data_zlozenia", columnDefinition = "DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate projectOrderSubmissionDate;

    @Column(name = "zlecenie_projektu_data_potwierdzenia", columnDefinition = "DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate projectOrderConfirmationDate;

    @Column(name = "pelnomocnictwo_data_zlozenia", columnDefinition = "DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate proxySubmissionDate;

    @Column(name = "pelnomocnictwo_data_otrzymania", columnDefinition = "DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate proxyReceiptDate;

    @Column(name = "mape_dostarczyl")
    private Integer mapProvidedBy;

    @Column(name = "zudp_data_wysl_geodecie", columnDefinition = "DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate zudpSentToSurveyorDate;

    @Column(name = "proj_org_ruchu_data_zlozenia", columnDefinition = "DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate trafficOrganizationProjectSubmissionDate;

    @Column(name = "proj_org_ruchu_data_otrzymania", columnDefinition = "DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate trafficOrganizationProjectReceiptDate;

    @Column(name = "odbior_wsg_koncowy", columnDefinition = "DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate wsgFinalAcceptanceDate;

    @Column(name = "nr_umowy_przylaczeniowej")
    private String connectionAgreementNumber;

    @Column(name = "nr_sap_up")
    private String sapUpNo;

    @Column(name = "zakres_wlaczenie")
    private String  scopeConnection;

    @Column(name = "zakres_stacja")
    private String scopeStation;

    @Column(name = "zakres_stacja_ile")
    private Integer scopeStationAmount;

    @Column(name = "zakres")
    private String scopeGasConnection;

    @Column(name = "zakres_ile")
    private Integer scopeGasConnectionAmount;

    @Column(name = "szafke_dostarcza")
    private String cabinetProvidedBy;

    @Column(name = "szafke_dostarcza_data", columnDefinition = "DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate cabinetProvidedByDate;

    @Column(name = "kalendarz", columnDefinition = "DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate taskCalendarDate;

    @Column(name = "rozdzielnia")
    private String substationName;

    @Column(name = "id_wewn")
    private Integer gasInternalId;

    @Column(name = "nr_wewn")
    private String gasInternalNo;

    @Column(name = "id_projektanta")
    private Integer idDesigner;

    @Column(name = "czy_byla_faktura")
    private Boolean isInvoice;

    @Column(name = "etap")
    private Integer stage;

    @Column(name = "odbior_wsg_koncowy_data_wyslania", columnDefinition = "DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate wsgFinalAcceptanceSubmissionDate;

    @Column(name = "bez_proj_org_ruchu")
    private Boolean withoutTrafficOrganizationProject;

    @Column(name = "data_przyspieszenia", columnDefinition = "DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate accelerationDate;

}
