package focik.net.progasoffice.userservice.infrastructure.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "settings_column_view")
public class ColumnViewDbDto {
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
