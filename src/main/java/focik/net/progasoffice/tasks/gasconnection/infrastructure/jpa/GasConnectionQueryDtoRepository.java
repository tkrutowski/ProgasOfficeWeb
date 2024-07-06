package focik.net.progasoffice.tasks.gasconnection.infrastructure.jpa;

import focik.net.progasoffice.tasks.gasconnection.infrastructure.dto.GasConnectionQueryDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

interface GasConnectionQueryDtoRepository extends JpaRepository<GasConnectionQueryDto, Integer> {
    List<GasConnectionQueryDto> findAllByIsFinished(Boolean isFinished);

//    @Query(value = "SELECT g FROM GasConnectionQueryDto g WHERE g.isFinished = false AND "
//            + "(g.wsgTechnicalAcceptanceDate = '0001-01-01' OR g.wsgTechnicalAcceptanceDate IS NULL) "
//            + "AND (g.wsgFinalAcceptanceDate = '0001-01-01' OR g.wsgFinalAcceptanceDate IS NULL)")


    @Query(value = "SELECT * FROM przylacze_view_java WHERE czy_zakonczone = 'false' AND "
            + "(odbior_wsg_techniczny = '0001-01-01' OR odbior_wsg_techniczny IS NULL) "
            + "AND (odbior_wsg_koncowy = '0001-01-01' OR odbior_wsg_koncowy IS NULL)", nativeQuery = true)
    List<GasConnectionQueryDto> findAllNotFinished();


    @Query(value = "select * from przylacze_view_java where czy_zakonczone = 'false' AND odbior_wsg_techniczny > '0001-01-01' " +
            "AND(odbior_wsg_koncowy = '0001-01-01' OR odbior_wsg_koncowy is null) " +
            "AND (odbior_wsg_koncowy_data_wyslania = '0001-01-01' OR odbior_wsg_koncowy_data_wyslania is null)",
            nativeQuery = true)
    List<GasConnectionQueryDto> findAllNotFinishedTech();

    @Query(value = "select * from przylacze_view_java where czy_zakonczone = 'false' AND odbior_wsg_koncowy_data_wyslania>'0001-01-01'",
            nativeQuery = true)
    List<GasConnectionQueryDto> findAllNotFinishedEnd();

    @Query(value = "select * from przylacze_view_java where czy_zakonczone='false' AND termin_wykonania < ?1",
            nativeQuery = true)
    List<GasConnectionQueryDto> findAllOverdue(LocalDate date);
}
