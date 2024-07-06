package focik.net.progasoffice.userservice.domain.utility;

import focik.net.progasoffice.userservice.domain.AppUser;
import focik.net.progasoffice.userservice.domain.exceptions.UserNotFoundException;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class UserHelper {
    private UserHelper() { }

    public static String getUserName() {

        return SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
    }

    public static AppUser getPrincipal() {
        return Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication().getPrincipal())
                .filter(o -> o instanceof AppUser)
                .map(AppUser.class::cast)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
    }
}
