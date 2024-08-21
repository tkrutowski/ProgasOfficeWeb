package focik.net.progasoffice.tasks.common.domain.model;

import lombok.Getter;

@Getter
public enum Stage {
    LACK(-1),
    STAGE_1_YELLOW(0),
    STAGE_1_GREEN(1),

    STAGE_2_YELLOW(2),
    STAGE_2_GREEN(3),

    STAGE_3_YELLOW(4),
    STAGE_3_GREEN(5),

    STAGE_4_YELLOW(6),
    STAGE_4_GREEN(7);

    private final int value;

    Stage(int value) {
        this.value = value;
    }

}
