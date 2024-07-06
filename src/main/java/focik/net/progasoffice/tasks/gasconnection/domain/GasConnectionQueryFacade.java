package focik.net.progasoffice.tasks.gasconnection.domain;

import focik.net.progasoffice.share.TaskStatus;
import focik.net.progasoffice.tasks.gasconnection.domain.exceptions.GasConnectionDoesNotExistException;
import focik.net.progasoffice.tasks.gasconnection.domain.port.primary.GetGasConnectionQueryUseCase;
import focik.net.progasoffice.tasks.gasconnection.domain.port.secondary.GasConnectionQueryRepository;
import focik.net.progasoffice.tasks.gasconnection.infrastructure.dto.GasConnectionQueryDto;
import focik.net.progasoffice.userservice.domain.AppUser;
import focik.net.progasoffice.userservice.domain.utility.UserHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GasConnectionQueryFacade implements GetGasConnectionQueryUseCase {
    private final GasConnectionQueryRepository queryRepository;

    @Override
    public GasConnectionQueryDto getGasConnectionById(int id) {
        Optional<GasConnectionQueryDto> byId = queryRepository.findById(id);
        if (byId.isEmpty())
            throw new GasConnectionDoesNotExistException(id);

        return byId.get();
    }

    @Override
    public List<GasConnectionQueryDto> getGasConnectionByStatus(TaskStatus taskStatus) {
        List<GasConnectionQueryDto> gasConnectionList =  switch (taskStatus) {
            case ALL -> queryRepository.findAll();
            case FINISHED -> queryRepository.findAllByComplete(true);
            case NOT_FINISHED -> queryRepository.findAllNotFinished();
            case NOT_FINISHED_TECH -> queryRepository.findAllNotFinishedTech();
            case NOT_FINISHED_END -> queryRepository.findAllNotFinishedEnd();
            case OVER_DUE -> queryRepository.findAllOverdue();
        };
        
       return applyAccess(gasConnectionList);
    }

    private List<GasConnectionQueryDto> applyAccess(List<GasConnectionQueryDto> gasConnectionList) {
        AppUser user = UserHelper.getPrincipal();
        if(user.isAdmin())
            return gasConnectionList;

        //if user in not an employee he can only see his own tasks
        if (!user.isEmployee())
            return gasConnectionList.stream()
                    .filter(gasConnectionQueryDto -> gasConnectionQueryDto.getIdDesigner().equals(user.getIdDesigner()))
                    .toList();
        return gasConnectionList;
    }
}
