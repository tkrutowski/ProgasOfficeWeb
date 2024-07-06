package focik.net.progasoffice.tasks.designers.infrastructure.dto;

import focik.net.progasoffice.addresses.domain.Address;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Projektant")
public class DesignerDbDto {

    @Id
    @Column(name = "id_projektanta")
    private Integer id;
    @Column(name = "imie")
    private String name;
    @Column(name = "nazwisko")
    private String lastName;
    @Column(name = "tel")
    private String phone;
    @Column(name = "tel2")
    private String phone2;
    @Column(name = "mail")
    private String mail;
    @Column(name = "inne")
    private String info;
    @Column(name = "czy_aktywny")
    private Boolean isActive;
    @Column(name = "ulica")
    private String street;
    @Column(name = "miasto")
    private String city;
    @Column(name = "kod")
    private String zip;
    @Column(name = "czy_progas")
    private boolean isEmployee;
}
