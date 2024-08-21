package focik.net.progasoffice.tasks.common.domain.model;

import focik.net.progasoffice.share.ActiveStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UtilityCompanyType {
    private int id;
    private String name;
}
