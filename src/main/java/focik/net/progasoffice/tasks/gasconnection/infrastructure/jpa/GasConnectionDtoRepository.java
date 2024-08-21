package focik.net.progasoffice.tasks.gasconnection.infrastructure.jpa;

import focik.net.progasoffice.tasks.common.domain.model.Stage;
import focik.net.progasoffice.tasks.gasconnection.infrastructure.dto.GasConnectionDbDto;
import focik.net.progasoffice.tasks.gasconnection.infrastructure.dto.GasConnectionQueryDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

interface GasConnectionDtoRepository extends JpaRepository<GasConnectionDbDto, Integer> {

    @Modifying
    @Query("UPDATE GasConnectionDbDto g SET g.stage = :stage WHERE g.id = :idTask")
    void updateStage(@Param("idTask") Integer idTask, @Param("stage") Stage stage);

//    @Modifying
//    @Query(value = "update przylacze set etap = ?1  where id_przylacza = ?2",
//            nativeQuery = true)
//    void updateStage(Integer stage,  Integer idTask);


    List<GasConnectionDbDto> findAllByIsFinished(Boolean isFinish);
}
