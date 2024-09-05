package focik.net.progasoffice.tasks.workrange.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum GasStationType {
    REDUCTION("redukcyjna"),
    MEASUREMENT ("pomiarowa"),
    REDUCTION_MEASUREMENT("redukcyjno - pomiarowa");

    private final String viewValue;

    GasStationType(String viewValue) {
        this.viewValue = viewValue;
    }
    public String getName() {
        return this.name();
    }

}
