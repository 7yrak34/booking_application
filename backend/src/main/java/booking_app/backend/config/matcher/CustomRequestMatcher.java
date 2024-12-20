package booking_app.backend.config.matcher;

import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.regex.Pattern;
import org.springframework.security.web.util.matcher.RequestMatcher;

public class CustomRequestMatcher implements RequestMatcher {

    private final List<Pattern> publicPatterns = List.of(
            Pattern.compile("^/api/hotels(/\\d+)?$"),
            Pattern.compile("^/api/rooms(/\\d+)?$")
    );

    @Override
    public boolean matches(HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        String method = request.getMethod();

        boolean isPublic = method.equalsIgnoreCase("GET") &&
                publicPatterns.stream().anyMatch(pattern -> pattern.matcher(requestURI).matches());
        return isPublic;
    }

}
