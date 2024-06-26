package api.chat.root.user.domain.verification;

import java.time.LocalDateTime;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 3/31/24
 */

public record VerificationCode(String code, LocalDateTime expirationTime) {

	public static VerificationCode generate() {
		return new VerificationCode("1234", LocalDateTime.now().plusMinutes(5));
	}

	public boolean isExpired() {
		return LocalDateTime.now().isAfter(this.expirationTime);
	}

	public boolean hasNotMatched(String code) {
		return this.code.equalsIgnoreCase(code);
	}
}
