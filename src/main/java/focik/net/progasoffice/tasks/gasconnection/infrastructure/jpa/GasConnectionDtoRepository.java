package focik.net.progasoffice.tasks.gasconnection.infrastructure.jpa;

import focik.net.progasoffice.tasks.gasconnection.infrastructure.dto.GasConnectionDbDto;
import focik.net.progasoffice.tasks.gasconnection.infrastructure.dto.GasConnectionQueryDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

interface GasConnectionDtoRepository extends JpaRepository<GasConnectionDbDto, Integer> {
}
