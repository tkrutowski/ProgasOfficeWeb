package focik.net.progasoffice.userservice.infrastructure.jpa;


import focik.net.progasoffice.userservice.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleDtoRepository extends JpaRepository<Role, Long> {
}
