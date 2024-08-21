package focik.net.progasoffice.tasks.gasconnection.infrastructure.mapper;

import focik.net.progasoffice.share.ActiveStatus;
import focik.net.progasoffice.tasks.designers.domain.model.Designer;
import focik.net.progasoffice.tasks.designers.infrastructure.dto.DesignerDbDto;
import focik.net.progasoffice.tasks.gasconnection.domain.model.GasConnection;
import focik.net.progasoffice.tasks.gasconnection.infrastructure.dto.GasConnectionDbDto;
import org.springframework.stereotype.Component;

@Component
public class JpaGasConnectionMapper {

//    public GasConnectionDbDto toDto(Designer d) {
//        return DesignerDbDto.builder()
//                .id(d.getId())
//                .name(d.getName())
//                .lastName(d.getLastName())
//                .phone(d.getPhone())
//                .phone2(d.getPhone2())
//                .mail(d.getMail())
//                .info(d.getInfo())
//                .city(d.getCity())
//                .street(d.getStreet())
//                .zip(d.getZip())
//                .isEmployee(d.isEmployee())
//                .isActive(getActive(d.getStatus()))
//                .build();
//    }


    public void addDesign(GasConnection gasConnection, GasConnectionDbDto dto) {

    }

    private ActiveStatus getActive(Boolean isActive) {
        if (isActive)
            return ActiveStatus.ACTIVE;
        else return ActiveStatus.INACTIVE;
    }

    private Boolean getActive(ActiveStatus status) {
        return status == ActiveStatus.ACTIVE;
    }
}