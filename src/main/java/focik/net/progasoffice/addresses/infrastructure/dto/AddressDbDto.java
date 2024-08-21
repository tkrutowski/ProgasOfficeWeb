package focik.net.progasoffice.addresses.infrastructure.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "addresses")
//@Table(name = "address_gasconnection_view_test")
@ToString
public class AddressDbDto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    private String commune;
    private String city;
    private String street;
    private String zip;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_coordinates", referencedColumnName = "id")
    private GeoCoordinatesDbDto coordinates;

}
