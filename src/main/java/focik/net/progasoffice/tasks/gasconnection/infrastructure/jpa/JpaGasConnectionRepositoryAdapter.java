package focik.net.progasoffice.tasks.gasconnection.infrastructure.jpa;

import focik.net.progasoffice.share.TaskStatus;
import focik.net.progasoffice.tasks.common.domain.model.Stage;
import focik.net.progasoffice.tasks.gasconnection.domain.exceptions.GasConnectionDoesNotExistException;
import focik.net.progasoffice.tasks.gasconnection.domain.model.GasConnection;
import focik.net.progasoffice.tasks.gasconnection.domain.model.GasConnectionBuild;
import focik.net.progasoffice.tasks.gasconnection.domain.model.GasConnectionDesign;
import focik.net.progasoffice.tasks.gasconnection.domain.port.secondary.GasConnectionQueryRepository;
import focik.net.progasoffice.tasks.gasconnection.domain.port.secondary.GasConnectionRepository;
import focik.net.progasoffice.tasks.gasconnection.infrastructure.dto.GasConnectionDbDto;
import focik.net.progasoffice.tasks.gasconnection.infrastructure.dto.GasConnectionQueryDto;
import focik.net.progasoffice.tasks.gasconnection.infrastructure.mapper.JpaGasConnectionMapper;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
@Primary
class JpaGasConnectionRepositoryAdapter implements GasConnectionRepository {

private final ModelMapper modelMapper;
    private final GasConnectionDtoRepository gasConnectionDtoRepository;
    private final JpaGasConnectionMapper connectionMapper;

    @Override
    public Optional<GasConnection> findById(Integer id) {
        Optional<GasConnectionDbDto> byId = gasConnectionDtoRepository.findById(id);
//        if (byId.isPresent()) {
//            GasConnection gasConnection = modelMapper.map(byId.get(), GasConnection.class);
//            gasConnection.setGasConnectionDesign(modelMapper.map(gasConnection.getGasConnectionDesign(), GasConnectionDesign.class));
////            connectionMapper.addDesign(gasConnection, byId.get());
//
//        }

        return  byId.map(gasConnectionDbDto -> {
            GasConnection gasConnection = modelMapper.map(gasConnectionDbDto, GasConnection.class);
            gasConnection.setGasConnectionDesign(modelMapper.map(gasConnectionDbDto, GasConnectionDesign.class));
            gasConnection.setGasConnectionBuild(modelMapper.map(gasConnectionDbDto, GasConnectionBuild.class));
            return gasConnection;
        });
//        return Optional.of(modelMapper.map(byId.get(), GasConnection.class));
    }


    @Override
    public List<GasConnection> findAll() {
        List<GasConnectionDbDto> all = gasConnectionDtoRepository.findAll();
        return mapToDomain(all);
    }

    @Override
    public List<GasConnection> findAllByFinish(Boolean isFinish) {
        List<GasConnectionDbDto> allByIsFinished = gasConnectionDtoRepository.findAllByIsFinished(isFinish);
        return mapToDomain(allByIsFinished);
    }


    @Override
    @Transactional
    public void updateStage(Integer idTask, Stage stage) {
        gasConnectionDtoRepository.updateStage(idTask, stage);
    }

    private List<GasConnection> mapToDomain(List<GasConnectionDbDto> all) {
        return all.stream()
                .map(gasConnectionDbDto -> {
                    GasConnection gasConnection = modelMapper.map(gasConnectionDbDto, GasConnection.class);
                    gasConnection.setGasConnectionDesign(modelMapper.map(gasConnectionDbDto, GasConnectionDesign.class));
                    gasConnection.setGasConnectionBuild(modelMapper.map(gasConnectionDbDto, GasConnectionBuild.class));
                    return gasConnection;
                }).toList();
    }
}
