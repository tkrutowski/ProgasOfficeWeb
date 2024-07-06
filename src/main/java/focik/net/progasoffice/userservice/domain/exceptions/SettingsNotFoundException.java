package focik.net.progasoffice.userservice.domain.exceptions;

public class SettingsNotFoundException extends RuntimeException {
    public SettingsNotFoundException(String message) {
        super(message);
    }
}
