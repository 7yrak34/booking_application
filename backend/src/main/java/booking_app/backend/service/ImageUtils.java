package booking_app.backend.service;

import org.springframework.stereotype.Component;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ImageUtils {
    public static List<String> convertToBase64(List<byte[]> images) {
        return images.stream()
                .map(Base64.getEncoder()::encodeToString)
                .collect(Collectors.toList());
    }
}
