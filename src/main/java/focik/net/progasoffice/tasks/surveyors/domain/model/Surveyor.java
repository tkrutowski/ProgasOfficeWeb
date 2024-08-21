package focik.net.progasoffice.tasks.surveyors.domain.model;

import focik.net.progasoffice.share.ActiveStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Surveyor {
    private int id;
    private String name;
    private String lastName;
    private String phone;
    private String phone2;
    private String mail;
    private String info;
    private ActiveStatus status;
}
