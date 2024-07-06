package focik.net.progasoffice.userservice.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Settings {
    private Long userId;
    private GasConnectionSettings gasConnectionSettings;

    public Settings(Long userId, GasConnectionSettings gasConnectionSettings) {
        validUser(userId);
        this.userId = userId;
        validGasConnection(gasConnectionSettings);
        this.gasConnectionSettings = gasConnectionSettings;
    }

    private void validGasConnection(GasConnectionSettings gasConnectionSettings) {
        if (gasConnectionSettings == null) {
            throw new IllegalArgumentException("GasConnectionSettings cannot be null");
        }
    }

    private void validUser(Long userId) {
        if (userId == null) {
            throw new IllegalArgumentException("UserID cannot be null");
        }
        if (userId <= 0) {
            throw new IllegalArgumentException("UserID must be greater than 0");
        }
    }
}
