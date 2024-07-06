package focik.net.progasoffice.userservice.infrastructure.dto;

import focik.net.progasoffice.share.DisplayByOwnershipEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

//@NamedQuery(
//        name = "GasConnectionSettingsDbDto.deleteAllByUserId",
//        query = "DELETE FROM GasConnectionSettingsDbDto g WHERE g.userId = :userId"
//)
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "settings_gas_connection")
public class GasConnectionSettingsDbDto {
    @Id
    @Column(name = "user_id", nullable = false)
    private Long userId;
    private String sortColumn;
    private Boolean sortDirection;
    private Integer rowsNumber;
    private String displayStatus;
    @Enumerated(EnumType.STRING)
    private DisplayByOwnershipEnum displayByOwnership;
    private String colorCompleted;
    private String colorBeforeDeadline;
    private Integer daysBeforeFinishDeadline;
    private String colorOverdue;
    private String colorSubmission;
    private String colorReceipt;
    private String colorFvReady;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private Set<ColumnViewDbDto> gasConnectionColumns;

    //design
    private Integer daysBeforeProjectDeadline;
    private String sortColumnDesign;
    private Boolean sortDirectionDesign;
    private Integer rowsNumberDesign;
    private String displayStatusDesign;
    @Enumerated(EnumType.STRING)
    private DisplayByOwnershipEnum displayByOwnershipDesign;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private Set<ColumnDesignViewDbDto> gasConnectionColumnsDesign;
}
