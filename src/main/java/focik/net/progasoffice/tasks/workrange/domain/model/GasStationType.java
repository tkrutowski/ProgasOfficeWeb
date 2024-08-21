package focik.net.progasoffice.tasks.workrange.domain.model;

import lombok.Getter;

@Getter
public enum GasStationType {
    REDUCTION("redukcyjna"),
    MEASUREMENT ("pomiarowa"),
    REDUCTION_MEASUREMENT("redukcyjno - pomiarowa");

    private final String viewValue;

    GasStationType(String viewValue) {
        this.viewValue = viewValue;
    }

}
