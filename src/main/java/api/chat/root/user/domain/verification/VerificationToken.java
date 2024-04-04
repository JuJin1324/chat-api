package api.chat.root.user.domain.verification;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 3/31/24
 */

public record VerificationToken(UUID value, LocalDateTime expirationTime) {
	public static VerificationToken generate() {
		return new VerificationToken(UUID.randomUUID(), LocalDateTime.now().plusMinutes(30));
	}
}
