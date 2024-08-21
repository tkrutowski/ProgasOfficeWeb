package focik.net.progasoffice.tasks.common.domain.model;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@Getter
@ToString
public enum Stage {
    LACK(-1, ""),
    STAGE_1_YELLOW(0, "ETAP 1"),
    STAGE_1_GREEN(1, "ETAP 1"),

    STAGE_2_YELLOW(2, "ETAP 2"),
    STAGE_2_GREEN(3, "ETAP 2"),

    STAGE_3_YELLOW(4, "ETAP 3"),
    STAGE_3_GREEN(5, "ETAP 3"),

    STAGE_4_YELLOW(6, "ETAP 4"),
    STAGE_4_GREEN(7, "ETAP 4");

    private final int value;
    private final String viewValue;

    Stage(int value, String viewValue) {
        this.value = value;
        this.viewValue = viewValue;
    }

    @JsonValue
    public Map<String, Object> toJson() {
        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("name", this.name());
        jsonMap.put("value", this.value);
        jsonMap.put("viewValue", this.viewValue);
        return jsonMap;
    }
}
