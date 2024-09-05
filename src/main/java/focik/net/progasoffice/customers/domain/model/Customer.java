package focik.net.progasoffice.customers.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private Integer id;
    private String firstName;
    private String name;
    private String phone;
    private String mail;
    private String info;
    private Boolean isActive;
    //todo zamienić na Address
    private String street;
    private String city;
    private String zip;
    private String nip;
}
