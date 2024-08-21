package focik.net.progasoffice.tasks.workrange.infrastructure.conventer;

import focik.net.progasoffice.tasks.common.domain.model.GasCabinetProviderType;
import focik.net.progasoffice.tasks.common.domain.model.TaskType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class GasCabinetProviderTypeConverter implements AttributeConverter<GasCabinetProviderType, String> {
    @Override
    public String convertToDatabaseColumn(GasCabinetProviderType attribute) {
        if(attribute == null){
            return null;
        }
        return attribute.getViewValue();
    }

    @Override
    public GasCabinetProviderType convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        return Stream.of(GasCabinetProviderType.values())
                .filter(type -> type.getViewValue().equals(dbData))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
