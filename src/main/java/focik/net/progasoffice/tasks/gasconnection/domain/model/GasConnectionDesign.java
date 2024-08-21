package focik.net.progasoffice.tasks.gasconnection.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import focik.net.progasoffice.tasks.common.domain.model.UtilityCompanyType;
import focik.net.progasoffice.tasks.designers.domain.model.DesignerTraffic;
import focik.net.progasoffice.tasks.surveyors.domain.model.Surveyor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GasConnectionDesign {
    //ETAP 1
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate projectOrderSubmissionDate;//ZlecenieProjektuDataZlozenia
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate projectOrderConfirmationDate; //ZlecenieProjektuDataPotwierdzenia
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate proxySubmissionDate; //PelnomocnictwoDataZlozenia
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate proxyReceiptDate; //PelnomocnictwoDataOtrzymania
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate mapSubmissionDate; //MapaDataZlozenia
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate mapReceiptDate; //MapaDataOtrzymania
    private int mapDeliveredBy; //MapeDostarczyl
    private Surveyor mapSurveyor; //MapaGeodeta
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate extractSubmissionDate; //wypis_data_zlozenia
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate extractReceiptDate; //wypis_data_otrzymania

    //ETAP 2
    private boolean withoutZud; // BezZud
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate zudpSubmissionDate; //ZudpDataZlozenia
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate zudpReceiptDate; //ZudpDataOtrzymania
    private UtilityCompanyType utilityCompanyType; //
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate utilityCompanySubmissionDate; //zaklad_komunalny_data_zlozenia
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate utilityCompanyReceiptDate; //zaklad_komunalny_data_otrzymania

    //ETAP 3
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate wsgAgreementSubmissionDate; //UzgodnienieWsgDataZlozenia
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate wsgAgreementReceiptDate; //UzgodnienieWsgDataOtrzymania
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate wsgAgreementAgreementDate; //UzgodnienieWsgDataUzg
    private String wsgAgreementNo; //UzgodnienieWsgNr
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate wsgAgreementPointSchemeSubmissionDate; //UzgSchematuPunktuWsgDataZlozenia
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate wsgAgreementPointSchemeReceiptDate; //UzgSchematuPunktuWsgDataOtrzymani

    //ETAP 4
    private boolean withoutTrafficOrganizationProject; //BezProjOrgRuchu
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate trafficOrganizationProjectSubmissionDate; //ProjOrgRuchuDataZlozenia
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate trafficOrganizationProjectReceiptDate; //ProjOrgRuchuDataOtrzymania
    private DesignerTraffic designerTraffic; //id_proj_org_ruchu
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate gasPointOrderDate; //PunktGazowy_dataZam
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate gasPointPickupDate; //PunktGazowy_dataOdb
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate gasPointDocPickupDate; // PunktGazowy_dataOdbDok
    private String gasPointOrderNo; //PunktGazowy_nrZamowienia
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate zudpSentToSurveyorDate; //GeodezjaDataWyslania
    private Surveyor surveyorTrafficProject; // IdGeodetyProjekt

}
