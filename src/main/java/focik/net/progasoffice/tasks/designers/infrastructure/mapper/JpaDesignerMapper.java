package focik.net.progasoffice.tasks.designers.infrastructure.mapper;

import focik.net.progasoffice.share.ActiveStatus;
import focik.net.progasoffice.tasks.designers.domain.model.Designer;
import focik.net.progasoffice.tasks.designers.infrastructure.dto.DesignerDbDto;
import org.springframework.stereotype.Component;

@Component
public class JpaDesignerMapper {

    public DesignerDbDto toDto(Designer d) {
        return DesignerDbDto.builder()
                .id(d.getId())
                .name(d.getName())
                .lastName(d.getLastName())
                .phone(d.getPhone())
                .phone2(d.getPhone2())
                .mail(d.getMail())
                .info(d.getInfo())
                .city(d.getCity())
                .street(d.getStreet())
                .zip(d.getZip())
                .isEmployee(d.isEmployee())
                .isActive(getActive(d.getStatus()))
                .build();
    }


    public Designer toDomain(DesignerDbDto dto) {
        return Designer.builder()
                .id(dto.getId())
                .name(dto.getName())
                .lastName(dto.getLastName())
                .phone(dto.getPhone())
                .phone2(dto.getPhone2())
                .mail(dto.getMail())
                .info(dto.getInfo())
                .city(dto.getCity())
                .street(dto.getStreet())
                .zip(dto.getZip())
                .isEmployee(dto.isEmployee())
                .status(getActive(dto.getIsActive()))
                .build();
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