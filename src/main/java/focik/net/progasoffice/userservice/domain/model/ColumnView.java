package focik.net.progasoffice.userservice.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ColumnView {
    private Integer id;
    private Integer sortIndex;
    private boolean isVisible;
    private boolean isFrozen;
    private String options;
    private String type;
    private boolean showFilterMatchModes;
    private String field;
    private String header;
    private String dataType;
}
