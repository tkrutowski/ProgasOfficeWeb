package focik.net.progasoffice.tasks.common.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum GasPressureType {
    MEDIUM("srednie", "średnie"),
    LOW("niskie","niskie"),
    HIGH("wysokie","wysokie");

    private final String viewValue;
    private final String displayValue;

    GasPressureType(String viewValue, String displayValue) {
        this.viewValue = viewValue;
        this.displayValue = displayValue;
    }

    public String getViewValue() {
        return viewValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
    public String getName() {
        return this.name();
    }
}
