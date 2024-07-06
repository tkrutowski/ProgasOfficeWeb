package focik.net.progasoffice.userservice.infrastructure.jpa;


import focik.net.progasoffice.userservice.domain.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;

interface IPrivilegeDtoRepository extends JpaRepository<Privilege, Long> {
//    Optional<Privilege> findByName(String name);
}
