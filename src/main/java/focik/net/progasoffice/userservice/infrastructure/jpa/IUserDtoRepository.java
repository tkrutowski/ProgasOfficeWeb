package focik.net.progasoffice.userservice.infrastructure.jpa;


import focik.net.progasoffice.userservice.domain.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

interface IUserDtoRepository extends JpaRepository<AppUser, Long> {

    Optional<AppUser> findByUsername(String username);
    Optional<AppUser> findByEmail(String email);

}
