package focik.net.progasoffice.tasks.common.domain;

import focik.net.progasoffice.tasks.common.domain.model.Stage;
import focik.net.progasoffice.tasks.common.domain.model.StageType;
import focik.net.progasoffice.tasks.plot.domain.model.Plot;
import focik.net.progasoffice.tasks.plot.domain.model.PlotOwnerPrivate;
import focik.net.progasoffice.tasks.surveyors.domain.model.Surveyor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StageUtils {

    private static final int PRIVATE_OWNER_ID = 5;

    public static StageType checkStage(LocalDate submissionDate, LocalDate receiptDate) {
        StageType stageType = StageType.LACK;
        if (submissionDate != null && !submissionDate.equals(LocalDate.of(1, 1, 1))) {
            stageType = StageType.YELLOW;

            if (receiptDate != null && !receiptDate.equals(LocalDate.of(1, 1, 1))) {
                stageType = StageType.GREEN;
            }
        }
        return stageType;
    }

    public static StageType calculateStage(List<StageType> stages) {
        boolean hasGreen = false;
        boolean hasYellow = false;
        boolean hasLack = false;

        for (StageType stage : stages) {
            switch (stage) {
                case GREEN:
                    hasGreen = true;
                    break;
                case YELLOW:
                    hasYellow = true;
                    break;
                case LACK:
                    hasLack = true;
                    break;
            }
        }

        if (hasGreen && !hasYellow && !hasLack) {
            return StageType.GREEN;
        } else if (hasGreen || hasYellow) {
            return StageType.YELLOW;
        } else {
            return StageType.LACK;
        }
    }

    public static Stage updateStage(Stage currentStage, StageType type) {
        return switch (currentStage) {
            case LACK ->
                    type.equals(StageType.YELLOW) ? Stage.STAGE_1_YELLOW : type.equals(StageType.GREEN) ? Stage.STAGE_1_GREEN : Stage.LACK;
            case STAGE_1_GREEN ->
                    type.equals(StageType.YELLOW) ? Stage.STAGE_2_YELLOW : type.equals(StageType.GREEN) ? Stage.STAGE_2_GREEN : Stage.STAGE_1_GREEN;
            case STAGE_2_GREEN ->
                    type.equals(StageType.YELLOW) ? Stage.STAGE_3_YELLOW : type.equals(StageType.GREEN) ? Stage.STAGE_3_GREEN : Stage.STAGE_2_GREEN;
            case STAGE_3_GREEN ->
                    type.equals(StageType.YELLOW) ? Stage.STAGE_4_YELLOW : type.equals(StageType.GREEN) ? Stage.STAGE_4_GREEN : Stage.STAGE_3_GREEN;
            default -> throw new IllegalStateException("Unexpected value: " + currentStage);
        };
    }

    public static StageType checkPlotsStage(List<Plot> plots, int shareLimit) {
        List<StageType> stageTypes = new ArrayList<>();

        if (plots.isEmpty()) {
            return StageType.LACK;
        }
        for (Plot plot : plots) {
            if (plot.getPlotOwner().getId() == PRIVATE_OWNER_ID && !plot.getConnectionEntity()) {
                stageTypes.add(checkPrivatePlots(plot.getPlotOwnerPrivate(), shareLimit));
            } else {
                stageTypes.add(StageUtils.checkStage(plot.getSubmissionDate(), plot.getReceiptDate()));
            }
        }
        return StageUtils.calculateStage(stageTypes);
    }

    public static StageType checkPrivatePlots(List<PlotOwnerPrivate> plotOwnerPrivate, int shareLimit) {
        if (plotOwnerPrivate.isEmpty()) {
            return StageType.GREEN;
        }
        int stageYellow = 0;
        int stageGreen = 0;
        int share = 0;
        for (PlotOwnerPrivate ownerPrivate : plotOwnerPrivate) {
            if ((ownerPrivate.getSubmissionDate() != null && !ownerPrivate.getSubmissionDate().equals(LocalDate.of(1, 1, 1))) ||
                    (ownerPrivate.getSubmissionDate1() != null && !ownerPrivate.getSubmissionDate1().equals(LocalDate.of(1, 1, 1))) ||
                    (ownerPrivate.getSubmissionDate2() != null && !ownerPrivate.getSubmissionDate2().equals(LocalDate.of(1, 1, 1)))) {

                stageYellow++;
                if ((ownerPrivate.getReceiptDate() != null && !ownerPrivate.getReceiptDate().equals(LocalDate.of(1, 1, 1))) ||
                        (ownerPrivate.getReceiptDate1() != null && !ownerPrivate.getReceiptDate1().equals(LocalDate.of(1, 1, 1))) ||
                        (ownerPrivate.getReceiptDate2() != null && !ownerPrivate.getReceiptDate2().equals(LocalDate.of(1, 1, 1)))) {
                    stageGreen++;
                    share += ownerPrivate.getShare();
                }
            }
        }

        if (stageYellow > 0 && share < shareLimit) {
            return StageType.YELLOW;
        }

        return (stageYellow > 0 && stageYellow == stageGreen) ? StageType.GREEN : stageYellow > 0 ? StageType.YELLOW : StageType.LACK;
    }

    public static StageType checkPlotsLaneOccupationStage(List<Plot> plots) {
        List<StageType> stageTypes = new ArrayList<>();

        if (plots.isEmpty()) {
            return StageType.LACK;
        }
        for (Plot plot : plots) {
            if (plot.getPlotOwner().getId() != PRIVATE_OWNER_ID) {
                stageTypes.add(StageUtils.checkStage(plot.getLaneOccupationSubmissionDate(), plot.getLaneOccupationReceiptDate()));
            }
        }
        //returns GREEN if there are only private plots
        return stageTypes.isEmpty() ? StageType.GREEN : StageUtils.calculateStage(stageTypes);
    }


    public static StageType checkSurveyor(LocalDate date, Surveyor surveyor) {
        if ((date != null && !date.equals(LocalDate.of(1, 1, 1))) && surveyor != null) {
            return StageType.GREEN;
        } else if ((date != null && !date.equals(LocalDate.of(1, 1, 1))) || surveyor != null) {
            return StageType.GREEN;
        } else {
            return StageType.LACK;
        }
    }
}
