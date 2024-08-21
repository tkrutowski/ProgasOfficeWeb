package focik.net.progasoffice.tasks.common.domain.model;

public enum StageType {
    LACK(-1),
    YELLOW(0),
    GREEN(1);

    private final int value;

    StageType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
