package focik.net.progasoffice.userservice.domain.model;

import focik.net.progasoffice.share.DisplayByOwnershipEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class GasConnectionSettings {
    private String sortColumn;
    private Boolean sortDirection;
    private Integer rowsNumber;
    private String displayStatus;
    private DisplayByOwnershipEnum displayByOwnership;
    private String colorCompleted;
    private String colorBeforeDeadline;
    private Integer daysBeforeProjectDeadline;
    private Integer daysBeforeFinishDeadline;
    private String colorOverdue;
    private String colorSubmission;
    private String colorReceipt;
    private String colorFvReady;
    private List<ColumnView> gasConnectionColumns;
    //design
    private List<ColumnView> gasConnectionColumnsDesign;
    private String sortColumnDesign;
    private Boolean sortDirectionDesign;
    private Integer rowsNumberDesign;
    private String displayStatusDesign;
    private DisplayByOwnershipEnum displayByOwnershipDesign;
}
