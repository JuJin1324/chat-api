package api.chat.root.user.domain.authentication;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 3/31/24
 */

public record AccessToken(UUID value, LocalDateTime expirationTime) {
	private static final int HOURS_24 = 60 * 60 * 24;

	public static AccessToken generate() {
		return new AccessToken(UUID.randomUUID(), LocalDateTime.now().plusMinutes(HOURS_24));
	}
}
