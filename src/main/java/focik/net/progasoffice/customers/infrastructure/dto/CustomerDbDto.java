package focik.net.progasoffice.customers.infrastructure.dto;

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
@Table(name = "Klient")
public class CustomerDbDto {

    @Id
    @Column(name = "id_klienta")
    private Integer id;
    @Column(name = "imie")
    private String firstName;
    @Column(name = "nazwa")
    private String name;
    @Column(name = "tel")
    private String phone;
    @Column(name = "mail")
    private String mail;
    @Column(name = "inne")
    private String info;
    @Column(name = "aktualny")
    private Boolean isActive;
    @Column(name = "ulica")
    private String street;
    @Column(name = "miasto")
    private String city;
    @Column(name = "kod")
    private String zip;
    @Column(name = "nip")
    private String nip;
}
