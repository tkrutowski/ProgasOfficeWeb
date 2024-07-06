package focik.net.progasoffice.tasks.gasconnection.infrastructure.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "przylacze")
public class GasConnectionDbDto {
    @Id
    @Column(name = "id_przylacza")
    private Integer id;

    @Column(name = "id_klienta")
    private Integer idCustomer;

    //TODO move to Address.class
    @Column(name = "gmina")
    private String commune;

    //TODO move to Address.class
    @Column(name = "miasto")
    private String city;

    //TODO move to Address.class
    @Column(name = "ulica_dzialka")
    private String street;

    @Column(name = "nr_zadania")
    private String taskNo;

    @Column(name = "nr_umowy")
    private String contractNo;

    @Column(name = "nr_warunkow")
    private String conditionNo;

    @Column(name = "data_warunkow", columnDefinition = "DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate conditionDate;

    @Column(name = "rozdzielnia")//jedn. zlecająca
    private String idGasDistribution;

    @Column(name = "nr_umowy_przylaczeniowej")
    private String connectionAgreementNumber;

    @Column(name = "nr_sap_up")
    private String sapUpNo;

    @Column(name = "data_przyspieszenia", columnDefinition = "DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate accelerationDate;

    @Column(name = "data_umowy", columnDefinition = "DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate contractDate;

    //termin odb końcowego
    @Column(name = "termin_wykonania", columnDefinition = "DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate finishDeadline;

    @Column(name = "termin_projektu", columnDefinition = "DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate projectDeadline;

    @Column(name = "termin_odb_koncowego", columnDefinition = "DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate wsgFinalPickupDate;

    @Column(name = "wartosc_zadania")
    private BigDecimal taskValue;

    @Column(name = "wartosc_projektu")
    private BigDecimal projectValue;

    @Column(name = "wartosc_wykonawstwa")
    private BigDecimal constructionValue;

    @Deprecated
    @Column(name = "id_inspektora")
    private Integer idInspector;

    @Column(name = "id_projektanta")
    private String idDesigner;

    @Column(name = "id_koordynatora")
    private Integer idCoordinator;

    @Column(name = "id_koordynatora_projekt")
    private Integer idCoordinatorProject;

    @Column(name = "czy_PGN")
    private Boolean isPGN;

    @Column(name = "uwagi")
    private String info;

    @Column(name = "czy_zakonczone")
    private Boolean isFinished;

    @Column(name = "id_przylacza_sync")
    private Integer idGasConnectionSync;

    @Column(name = "id_address")
    private Integer idAddress;

    //
    //PROJEKT
    //
    //STAGE 1
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

    @Column(name = "mapa_data_zlozenia", columnDefinition = "DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate mapSubmissionDate;

    @Column(name = "mapa_data_otrzymania", columnDefinition = "DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate mapReceiptDate;

    @Column(name = "mape_dostarczyl")
    private Integer map_deliveredBy;

    @Column(name = "mapa_geodeta")
    private Integer mapSurveyor;

    @Column(name = "wypis_data_zlozenia", columnDefinition = "DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate extractSubmissionDate;

    @Column(name = "wypis_data_otrzymania", columnDefinition = "DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate extractReceiptDate;



    //STAGE 2
    @Column(name = "bez_zud")
    private Boolean withoutZud;

    @Column(name = "zudp_data_zlozenia", columnDefinition = "DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate zupdSubmissionDate;

    @Column(name = "zudp_data_otrzymania", columnDefinition = "DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate zudpReceiptDate;

    @Column(name = "id_rodzaj_zakladu_kom")
    private Integer idMunicipalFacility;

    @Column(name = "zaklad_komunalny_data_zlozenia", columnDefinition = "DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate municipalFacilitySubmissionDate;

    @Column(name = "zaklad_komunalny_data_otrzymania", columnDefinition = "DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate municipalFacilityReceiptDate;


    //STAGE 3
    @Column(name = "uzgodnienie_wsg_data_zlozenia", columnDefinition = "DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate wsgAgreementSubmissionDate;

    @Column(name = "uzgodnienie_wsg_data_otrzymania", columnDefinition = "DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate wsgAgreementReceiptDate;

    @Column(name = "uzgodnienie_wsg_data_uzg", columnDefinition = "DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate wsgAgreementAgreementDate;

    @Column(name = "uzgodnienie_wsg_nr")
    private String wsgAgreementNo;

    @Column(name = "uzgodnienie_schematu_punktu_wsg_data_zlozenia", columnDefinition = "DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate wsgAgreementPointSchemeSubmissionDate;

    @Column(name = "uzgodnienie_schematu_punktu_wsg_data_otrzymania", columnDefinition = "DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate wsgAgreementPointSchemeReceiptDate;


    //STAGE 4
    @Column(name = "proj_org_ruchu")
    private Boolean isTrafficOrganizationProject;

    //Powoduje wyszarzenie się komurek dotyczących projektu org ruchu w tabeli głównej.
    @Column(name = "bez_proj_org_ruchu")
    private Boolean withoutTrafficOrganizationProject;

    @Column(name = "proj_org_ruchu_data_zlozenia", columnDefinition = "DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate trafficOrganizationProjectSubmissionDate;

    @Column(name = "proj_org_ruchu_data_otrzymania", columnDefinition = "DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate trafficOrganizationProjectReceiptDate;

    @Column(name = "id_proj_org_ruchu")
    private Integer idTrafficOrganizationProject;

    @Column(name = "punkt_gazowy_data_zam", columnDefinition = "DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate gasPointOrderDate;

    @Column(name = "punkt_gazowy_data_odb", columnDefinition = "DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate gasPointPickupDate;

    @Column(name = "punkt_gazowy_data_odb_dok", columnDefinition = "DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate gasPointDocPickupDate;

    @Column(name = "punkt_gazowy_nr_zam")
    private LocalDate gasPointOrderNo;

    @Column(name = "zudp_data_wysl_geodecie", columnDefinition = "DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate zudpSentToSurveyorDate;

    @Column(name = "id_geodety_projekt")
    private Integer idSurveyorProject;

    //TODO enum instead of int???
    @Column(name = "etap")
    private Integer stage;



    //BUILD
    @Column(name = "zaw_rozdzielni_data_zlozenia", columnDefinition = "DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate substationNotificationSubmissionDate;

    @Column(name = "geodezja_szkice", columnDefinition = "DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate surveyingSketchesDate;

    @Column(name = "geodezja_inwentaryzacja", columnDefinition = "DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate surveyingInventoryDate;

    @Column(name = "realizacja_data_rozpoczecia", columnDefinition = "DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate realizationStartDate;

    @Column(name = "realizacja_data_zakonczenia", columnDefinition = "DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate realizationEndDate;

    @Column(name = "odbior_wsg_techniczny", columnDefinition = "DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate wsgTechnicalAcceptanceDate;

    @Column(name = "nr_protokolu_odbioru_tech")
    private String technicalAcceptanceProtocolNo;

    @Column(name = "nr_inwentarzowy_gazociagu")
    private String gasPipelineInventoryNumber;

    @Column(name = "dl_przyl_rzecz")
    private Float gasConnectionRealLength;

    @Column(name = "odbior_wsg_koncowy_data_wyslania", columnDefinition = "DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate wsgFinalAcceptanceSubmissionDate;

    @Column(name = "odbior_wsg_koncowy", columnDefinition = "DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate wsgFinalAcceptanceDate;

    @Column(name = "odbior_wsg_uwagi")
    private String wsgInfo;

    //PGN












    //FINANCE
    @Column(name = "finanse_inwentaryzacja_kwota")
    private BigDecimal financeInventoryAmount;
    @Column(name = "finanse_inwentaryzacja_data", columnDefinition = "DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate financeInventoryDate;
    @Column(name = "finanse_projekt_kwota")
    private BigDecimal financeProjektAmount;
    @Column(name = "finanse_projekt_data", columnDefinition = "DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate financeProjektDate;
    @Column(name = "finanse_pas_drogowy_kwota")
    private BigDecimal financeRoadPastureAmount;
    @Column(name = "finanse_pas_drogowy_data", columnDefinition = "DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate financeRoadPastureDate;




















    //DO USUNIECIA

    @Column(name = "zajecie_pasa_dok_data_przekazania", columnDefinition = "DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate laneOccupationDocTransferDate;

    @Column(name = "zajecie_pasa_dok_data_PSG", columnDefinition = "DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate laneOccupationDocPsgDate;
    @Column(name = "zajecie_pasa_dok_data_otrzymania", columnDefinition = "DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate laneOccupationDocReceiptDate;

    //przeslano_zud_geodecie
    //zajecie_pasa_podbite_przez_gazownie

}
