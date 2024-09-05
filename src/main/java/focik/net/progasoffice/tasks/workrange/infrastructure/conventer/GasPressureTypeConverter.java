package focik.net.progasoffice.tasks.workrange.infrastructure.conventer;

import focik.net.progasoffice.tasks.common.domain.model.GasPressureType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class GasPressureTypeConverter implements AttributeConverter<GasPressureType, String> {
    @Override
    public String convertToDatabaseColumn(GasPressureType attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.getViewValue();
    }

    @Override
    public GasPressureType convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        return Stream.of(GasPressureType.values())
                .filter(type -> type.getViewValue().equals(dbData))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
