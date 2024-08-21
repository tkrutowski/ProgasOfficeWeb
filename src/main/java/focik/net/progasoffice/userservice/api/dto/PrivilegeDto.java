package focik.net.progasoffice.userservice.api.dto;

import focik.net.progasoffice.share.PrivilegeType;
import focik.net.progasoffice.userservice.domain.Role;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrivilegeDto {
    private Long id;
    private Long idUser;
    private Role role;
    private PrivilegeType read;
    private PrivilegeType write;
    private PrivilegeType delete;
}
