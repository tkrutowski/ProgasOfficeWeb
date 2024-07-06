package focik.net.progasoffice.tasks.inspectors.infrastructure.dto;

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
@Table(name = "Inspektor")
public class InspectorDbDto {

    @Id
    @Column(name = "id_inspektora")
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
}
