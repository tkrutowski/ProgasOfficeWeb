package focik.net.progasoffice.tasks.common.infrastructure.dto;

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
@Table(name = "Rodzaj_zakladu_kom")
public class UtilityCompanyTypeDbDto {

    @Id
    @Column(name = "id_zakladu")
    private Integer id;
    @Column(name = "nazwa")
    private String name;
}
