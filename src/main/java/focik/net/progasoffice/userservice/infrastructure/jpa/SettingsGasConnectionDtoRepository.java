package focik.net.progasoffice.userservice.infrastructure.jpa;


import focik.net.progasoffice.userservice.infrastructure.dto.GasConnectionSettingsDbDto;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SettingsGasConnectionDtoRepository extends JpaRepository<GasConnectionSettingsDbDto, Long> {
//    @Query(value = "DELETE from settings_gas_connection where user_id = ?1",
//            nativeQuery = true)
    void deleteAllByUserId(Long userId);
//    @Query(name = "GasConnectionSettingsDbDto.deleteAllByUserId")
//    void deleteAllByUserId(@Param("userId") Long userId);

//    @Modifying
//    @Transactional
//    @Query("DELETE FROM GasConnectionSettingsDbDto g WHERE g.userId = :userId")
//    void deleteAllByUserId(@Param("userId") Long userId);
}
