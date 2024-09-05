package focik.net.progasoffice.tasks.gasconnection.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import focik.net.progasoffice.addresses.domain.Address;
import focik.net.progasoffice.customers.domain.model.Customer;
import focik.net.progasoffice.tasks.common.domain.StageUtils;
import focik.net.progasoffice.tasks.common.domain.model.Stage;
import focik.net.progasoffice.tasks.common.domain.model.StageType;
import focik.net.progasoffice.tasks.common.domain.model.Stageable;
import focik.net.progasoffice.tasks.common.domain.model.Task;
import focik.net.progasoffice.tasks.coordinator.domain.model.Coordinator;
import focik.net.progasoffice.tasks.designers.domain.model.Designer;
import focik.net.progasoffice.tasks.inspectors.domain.model.Inspector;
import focik.net.progasoffice.tasks.pgn.domain.model.Pgn;
import focik.net.progasoffice.tasks.plot.domain.model.Plot;
import focik.net.progasoffice.tasks.workrange.domain.model.WorkRangeConnection;
import focik.net.progasoffice.tasks.workrange.domain.model.WorkRangeGasConnection;
import focik.net.progasoffice.tasks.workrange.domain.model.WorkRangeGasStation;
import lombok.*;
import org.springframework.beans.factory.annotation.Value;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GasConnection extends Task implements Stageable {


    @Value("${gasconnection.plot.share-limit}")
    private int shareLimit;

    private Integer id;
    private Customer customer;
    private Inspector inspector;
    private Designer designer;
    private Coordinator coordinator;
    private Coordinator coordinatorProject;
    private Address address;
    private List<Plot> plots;
    private List<WorkRangeGasConnection> workRangeGasConnections;
    private List<WorkRangeGasStation> workRangeGasStations;
    private WorkRangeConnection workRangeConnection;
    private GasConnectionDesign gasConnectionDesign;
    private GasConnectionBuild gasConnectionBuild;
    private GasConnectionFinance gasConnectionFinance;
    private Pgn pgn;
    //nr_zadania
    private String taskNo;
    //nr_umowy
    private String contractNo;
    //nr_warunkow
    private String conditionNo;
    //data_warunkow
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate conditionDate;
    //rozdzielnia (jedn. zlecająca)
    private String idGasDistribution;
    //nr_umowy_przylaczeniowej
    private String connectionAgreementNumber;
    //nr_sap_up
    private String sapUpNo;
    //data_przyspieszenia
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate accelerationDate;
    //data_umowy
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate contractDate;
    //termin odb końcowego
    //termin_wykonania
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate finishDeadline;
    //termin_projektu
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate projectDeadline;
    //termin_odb_koncowego
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate wsgFinalPickupDate;
    //wartosc_zadania"
    private BigDecimal taskValue;
    //wartosc_projektu
    private BigDecimal projectValue;
    //wartosc_wykonawstwa
    private BigDecimal constructionValue;
    //czy_PGN
    private Boolean isPGN;
    //uwagi
    private String info;
    //czy_zakonczone
    private Boolean isFinished;
    //id_przylacza_sync
    private Integer idGasConnectionSync;
    //etap
    private Stage stage;


    public boolean hasWorkRangeGasStation(){
        return !workRangeGasStations.isEmpty();
    }


    @Override
    public Stage calculateStage() {
        Stage stage = Stage.LACK;

        //hook
        if (this.getGasConnectionDesign().getWsgAgreementSubmissionDate() != null && !this.getGasConnectionDesign().getWsgAgreementSubmissionDate().equals(LocalDate.of(1, 1, 1))){
            stage = Stage.STAGE_2_GREEN;
        }else {

            StageType stageOneMap = StageUtils.checkStage(this.getGasConnectionDesign().getMapSubmissionDate(), this.getGasConnectionDesign().getMapReceiptDate());
            StageType stageOneExtract = StageUtils.checkStage(this.getGasConnectionDesign().getExtractSubmissionDate(), this.getGasConnectionDesign().getExtractReceiptDate());

            StageType result = StageUtils.calculateStage(List.of(stageOneMap, stageOneExtract));

            stage = StageUtils.updateStage(stage, result);
        }

        //if STAGE 1 completed check STAGE 2
        if (stage.equals(Stage.STAGE_1_GREEN)) {
            StageType stageTwoZud = StageUtils.checkStage(this.getGasConnectionDesign().getZudpSubmissionDate(), this.getGasConnectionDesign().getZudpReceiptDate());
            StageType stageTwoPlots = StageUtils.checkPlotsStage(this.getPlots(), shareLimit);

            if (this.getGasConnectionDesign().isWithoutZud()){
                //check only plots
                stage = StageUtils.updateStage(stage, StageUtils.calculateStage(List.of(stageTwoPlots)));
            }else {
                stage = StageUtils.updateStage(stage, StageUtils.calculateStage(List.of(stageTwoPlots, stageTwoZud)));
            }
        }

        //if STAGE 2 completed check STAGE 3
        if (stage.equals(Stage.STAGE_2_GREEN)) {
            StageType stageThreeWsg = StageUtils.checkStage(this.getGasConnectionDesign().getWsgAgreementSubmissionDate(), this.getGasConnectionDesign().getWsgAgreementReceiptDate());

            if (!this.getWorkRangeGasStations().isEmpty()){
                StageType stageThreeWorkRangeStation = StageUtils.checkStage(this.getGasConnectionDesign().getWsgAgreementPointSchemeSubmissionDate(), this.getGasConnectionDesign().getWsgAgreementPointSchemeReceiptDate());
                stage = StageUtils.updateStage(stage, StageUtils.calculateStage(List.of(stageThreeWsg, stageThreeWorkRangeStation)));
            }else {
                stage = StageUtils.updateStage(stage, StageUtils.calculateStage(List.of(stageThreeWsg)));
            }
        }

        //if STAGE 3 completed check STAGE 4
        if (stage.equals(Stage.STAGE_3_GREEN)) {
            StageType stageFourTraffic = StageUtils.checkStage(this.getGasConnectionDesign().getTrafficOrganizationProjectSubmissionDate(), this.getGasConnectionDesign().getTrafficOrganizationProjectReceiptDate());
            StageType stageFourWorkRangeStation = StageUtils.checkStage(this.getGasConnectionDesign().getGasPointOrderDate(), this.getGasConnectionDesign().getGasPointPickupDate());
            StageType stageFourLaneOccupation = StageUtils.checkPlotsLaneOccupationStage(this.getPlots());
            StageType stageFourSurveyor = StageUtils.checkSurveyor(this.getGasConnectionDesign().getZudpSentToSurveyorDate(), this.getGasConnectionDesign().getSurveyorTrafficProject());

            List<StageType> stageTypes = new ArrayList<>();
            stageTypes.add(stageFourSurveyor);
            stageTypes.add(stageFourLaneOccupation);
            if (!this.getGasConnectionDesign().isWithoutTrafficOrganizationProject()){
                stageTypes.add(stageFourTraffic);
            }
            if (this.hasWorkRangeGasStation()){
                stageTypes.add(stageFourWorkRangeStation);
            }
            stage = StageUtils.updateStage(stage, StageUtils.calculateStage(stageTypes));
        }
        return stage;
    }
}
