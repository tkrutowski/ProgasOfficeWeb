package focik.net.progasoffice.tasks.common.domain;

import focik.net.progasoffice.tasks.common.domain.model.StageType;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StageUtilsTest {

    @Test
    public void testAllGreen() {
        List<StageType> stages = Arrays.asList(StageType.GREEN, StageType.GREEN, StageType.GREEN);
        StageType result = StageUtils.calculateStage(stages);
        assertEquals(StageType.GREEN, result, "All stages are GREEN, should return GREEN");
    }

    @Test
    public void testAllLack() {
        List<StageType> stages = Arrays.asList(StageType.LACK, StageType.LACK, StageType.LACK);
        StageType result = StageUtils.calculateStage(stages);
        assertEquals(StageType.LACK, result, "All stages are LACK, should return LACK");
    }

    @Test
    public void testMixedGreenAndYellow() {
        List<StageType> stages = Arrays.asList(StageType.GREEN, StageType.YELLOW, StageType.GREEN);
        StageType result = StageUtils.calculateStage(stages);
        assertEquals(StageType.YELLOW, result, "Stages contain GREEN and YELLOW, should return YELLOW");
    }

    @Test
    public void testMixedGreenAndLack() {
        List<StageType> stages = Arrays.asList(StageType.GREEN, StageType.LACK, StageType.LACK);
        StageType result = StageUtils.calculateStage(stages);
        assertEquals(StageType.YELLOW, result, "Stages contain GREEN and LACK, should return YELLOW");
    }

    @Test
    public void testMixedYellowAndLack() {
        List<StageType> stages = Arrays.asList(StageType.YELLOW, StageType.LACK, StageType.LACK);
        StageType result = StageUtils.calculateStage(stages);
        assertEquals(StageType.YELLOW, result, "Stages contain YELLOW and LACK, should return YELLOW");
    }

    @Test
    public void testSingleGreen() {
        List<StageType> stages = List.of(StageType.GREEN);
        StageType result = StageUtils.calculateStage(stages);
        assertEquals(StageType.GREEN, result, "Single stage GREEN, should return GREEN");
    }

    @Test
    public void testSingleYellow() {
        List<StageType> stages = List.of(StageType.YELLOW);
        StageType result = StageUtils.calculateStage(stages);
        assertEquals(StageType.YELLOW, result, "Single stage YELLOW, should return YELLOW");
    }

    @Test
    public void testSingleLack() {
        List<StageType> stages = List.of(StageType.LACK);
        StageType result = StageUtils.calculateStage(stages);
        assertEquals(StageType.LACK, result, "Single stage LACK, should return LACK");
    }

    @Test
    public void testEmptyList() {
        List<StageType> stages = List.of();
        StageType result = StageUtils.calculateStage(stages);
        assertEquals(StageType.LACK, result, "Empty list should be treated as all LACK, should return LACK");
    }


    @Test
    public void testNullDates() {
        StageType result = StageUtils.checkStage(null, null);
        assertEquals(StageType.LACK, result, "Both dates are null, should return LACK");
    }

    @Test
    public void testOnlySubmissionDateNotNullAndNotDefault() {
        LocalDate submissionDate = LocalDate.of(2024, 8, 13);
        StageType result = StageUtils.checkStage(submissionDate, null);
        assertEquals(StageType.YELLOW, result, "Submission date is set and not default, should return YELLOW");
    }

    @Test
    public void testOnlySubmissionDateDefault() {
        LocalDate submissionDate = LocalDate.of(1, 1, 1);
        StageType result = StageUtils.checkStage(submissionDate, null);
        assertEquals(StageType.LACK, result, "Submission date is default (1-1-1), should return LACK");
    }

    @Test
    public void testSubmissionDateAndReceiptDateNotNullAndNotDefault() {
        LocalDate submissionDate = LocalDate.of(2024, 8, 13);
        LocalDate receiptDate = LocalDate.of(2024, 8, 14);
        StageType result = StageUtils.checkStage(submissionDate, receiptDate);
        assertEquals(StageType.GREEN, result, "Both submission and receipt dates are set and not default, should return GREEN");
    }

    @Test
    public void testSubmissionDateNotNullAndNotDefaultButReceiptDateDefault() {
        LocalDate submissionDate = LocalDate.of(2024, 8, 13);
        LocalDate receiptDate = LocalDate.of(1, 1, 1);
        StageType result = StageUtils.checkStage(submissionDate, receiptDate);
        assertEquals(StageType.YELLOW, result, "Submission date is set and not default, but receipt date is default, should return YELLOW");
    }

    @Test
    public void testSubmissionDateDefaultAndReceiptDateNotNullAndNotDefault() {
        LocalDate submissionDate = LocalDate.of(1, 1, 1);
        LocalDate receiptDate = LocalDate.of(2024, 8, 14);
        StageType result = StageUtils.checkStage(submissionDate, receiptDate);
        assertEquals(StageType.LACK, result, "Submission date is default but receipt date is set and not default, should return GREEN");
    }

    @Test
    public void testDefaultDates() {
        LocalDate submissionDate = LocalDate.of(1, 1, 1);
        LocalDate receiptDate = LocalDate.of(1, 1, 1);
        StageType result = StageUtils.checkStage(submissionDate, receiptDate);
        assertEquals(StageType.LACK, result, "Both dates are default (1-1-1), should return LACK");
    }
}