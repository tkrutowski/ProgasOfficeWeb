package focik.net.progasoffice.tasks.designers.infrastructure.jpa;

import focik.net.progasoffice.share.ActiveStatus;
import focik.net.progasoffice.tasks.designers.domain.model.Designer;
import focik.net.progasoffice.tasks.designers.domain.port.secondary.DesignerRepository;
import focik.net.progasoffice.tasks.designers.infrastructure.dto.DesignerDbDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class DesignerRepositoryAdapter implements DesignerRepository {

    private final DesignerDtoRepository designerDtoRepository;
    private final ModelMapper modelMapper;

    @Override
    public Optional<Designer> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<Designer> findAllByStatus(ActiveStatus status) {
        List<DesignerDbDto> dtos = new ArrayList<>();
        switch (status) {
            case ACTIVE:
                dtos = designerDtoRepository.findAllByIsActive(true);
                break;
            case INACTIVE:
                dtos = designerDtoRepository.findAllByIsActive(false);
                break;
            case ALL:
                dtos = designerDtoRepository.findAll();
                break;
        }

        return dtos.stream()
                .map(designerDbDto -> modelMapper.map(designerDbDto, Designer.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<Designer> findAll() {
        return List.of();
    }

}
