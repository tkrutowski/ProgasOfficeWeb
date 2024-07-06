package focik.net.progasoffice.tasks.common;

public enum TaskType {
    GAS_CONNECTION("przylacze"),
    GAS_PIPELINE("gazociag"),
    GAS_INTERNAL("wewnetrzna"),
    ALL("inne");

    private final String viewValue;

    TaskType(String viewValue) {
        this.viewValue = viewValue;
    }

    public String getViewValue() {
        return viewValue;
    }
}
