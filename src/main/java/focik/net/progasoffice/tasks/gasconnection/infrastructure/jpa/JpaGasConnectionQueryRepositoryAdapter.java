package focik.net.progasoffice.tasks.gasconnection.infrastructure.jpa;

import focik.net.progasoffice.tasks.gasconnection.domain.port.secondary.GasConnectionQueryRepository;
import focik.net.progasoffice.tasks.gasconnection.infrastructure.dto.GasConnectionQueryDto;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
@Primary
class JpaGasConnectionQueryRepositoryAdapter implements GasConnectionQueryRepository {


    private GasConnectionQueryDtoRepository gasConnectionDtoRepository;

    @Override
    public Optional<GasConnectionQueryDto> findById(Integer id) {

        return gasConnectionDtoRepository.findById(id);
    }

    @Override
    public List<GasConnectionQueryDto> findAllByComplete(Boolean isFinished) {
        return gasConnectionDtoRepository.findAllByIsFinished(isFinished);
    }

    @Override
    public List<GasConnectionQueryDto> findAll() {
        return gasConnectionDtoRepository.findAll();
    }

    @Override
    public List<GasConnectionQueryDto> findAllNotFinished() {
        return gasConnectionDtoRepository.findAllNotFinished();
    }

    @Override
    public List<GasConnectionQueryDto> findAllNotFinishedTech() {
        return gasConnectionDtoRepository.findAllNotFinishedTech();
    }

    @Override
    public List<GasConnectionQueryDto> findAllNotFinishedEnd() {
        return gasConnectionDtoRepository.findAllNotFinishedEnd();
    }

    @Override
    public List<GasConnectionQueryDto> findAllOverdue() {
        return gasConnectionDtoRepository.findAllOverdue(LocalDate.now());
    }
}
