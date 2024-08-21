package focik.net.progasoffice.tasks.common.domain.model;

public enum GasCabinetProviderType {
    UNKNOWN("Nieznane"),
    CUSTOMER("Klient"),
    PSG("PSG"),
    COMPANY("Progas");

    private final String viewValue;

    GasCabinetProviderType(String viewValue) {
        this.viewValue = viewValue;
    }

    public String getViewValue() {
        return viewValue;
    }
}
