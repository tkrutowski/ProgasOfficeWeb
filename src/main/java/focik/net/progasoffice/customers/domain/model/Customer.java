package focik.net.progasoffice.customers.domain.model;

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
public class Customer {
    private int id;
    private String Name;
    private Address address;
    private String Nip;
    private String Phone;
    private String Fax;
    private String Mail;
    private String Info;
    private ActiveStatus activeStatus;
    private String firstName;
}
