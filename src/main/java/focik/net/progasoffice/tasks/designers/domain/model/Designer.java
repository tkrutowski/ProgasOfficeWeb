package focik.net.progasoffice.tasks.designers.domain.model;

import focik.net.progasoffice.addresses.domain.Address;
import focik.net.progasoffice.share.ActiveStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Designer {
    private int id;
    private String name;
    private String lastName;
    private String phone;
    private String phone2;
    private String mail;
    private String info;
    private String city;
    private String street;
    private String zip;
    private ActiveStatus status;
    private boolean isEmployee;
}
