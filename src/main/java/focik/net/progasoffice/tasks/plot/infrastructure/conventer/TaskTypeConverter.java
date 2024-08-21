package focik.net.progasoffice.tasks.plot.infrastructure.conventer;

import focik.net.progasoffice.tasks.common.domain.model.TaskType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class TaskTypeConverter implements AttributeConverter<TaskType, String> {
    @Override
    public String convertToDatabaseColumn(TaskType attribute) {
        if(attribute == null){
            return null;
        }
        return attribute.getViewValue();
    }

    @Override
    public TaskType convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        return Stream.of(TaskType.values())
                .filter(type -> type.getViewValue().equals(dbData))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
