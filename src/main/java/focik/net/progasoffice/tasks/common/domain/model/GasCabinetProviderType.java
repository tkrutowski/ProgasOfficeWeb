package focik.net.progasoffice.tasks.common.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum GasCabinetProviderType {
    UNKNOWN("Nieznane"),
    CUSTOMER("Klient"),
    PSG("PSG"),
    COMPANY("Progas");

    private final String viewValue;

    GasCabinetProviderType(String viewValue) {
        this.viewValue = viewValue;
    }

    public String getName() {
        return this.name();
    }
}
