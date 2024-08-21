package focik.net.progasoffice.addresses.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
class GeographicalCoordinates {

    private Long id;
    private String latitude; //szerokosc
    private String longitude; //długość


}
