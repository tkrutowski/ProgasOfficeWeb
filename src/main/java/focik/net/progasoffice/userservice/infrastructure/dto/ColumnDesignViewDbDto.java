package focik.net.progasoffice.userservice.infrastructure.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "settings_column_design_view")
public class ColumnDesignViewDbDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer sortIndex;
    private Boolean visible;
    private Boolean frozen;
    private String options;
    private String type;
    private Boolean showFilterMatchModes;
    private String field;
    private String header;
    private String dataType;
}
