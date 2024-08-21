package focik.net.progasoffice.tasks.workrange.infrastructure.conventer;

import focik.net.progasoffice.tasks.workrange.domain.model.GasStationType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class GasStationTypeConverter implements AttributeConverter<GasStationType, String> {
    @Override
    public String convertToDatabaseColumn(GasStationType attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.getViewValue();
    }

    @Override
    public GasStationType convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        return Stream.of(GasStationType.values())
                .filter(type -> type.getViewValue().equals(dbData))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
