package focik.net.progasoffice.tasks.gasconnection.infrastructure.conventer;

import focik.net.progasoffice.tasks.common.domain.model.Stage;
import focik.net.progasoffice.tasks.common.domain.model.TaskType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class StageConverter implements AttributeConverter<Stage, Integer> {
    @Override
    public Integer convertToDatabaseColumn(Stage attribute) {
        if(attribute == null){
            return null;
        }
        return attribute.getValue();
    }

    @Override
    public Stage convertToEntityAttribute(Integer dbData) {
        if (dbData == null) {
            return null;
        }
        return Stream.of(Stage.values())
                .filter(type -> type.getValue() ==dbData)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
