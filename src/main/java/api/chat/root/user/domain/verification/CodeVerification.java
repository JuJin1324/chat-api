package api.chat.root.user.domain.verification;

import java.time.LocalDateTime;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 4/1/24
 */

@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public abstract class CodeVerification {
	private VerificationCode verificationCode;
	private boolean verified;
	private LocalDateTime expirationTime;

	public void verify(String code) {
		requireCode(code);

		this.verificationCode = null;
		this.verified = true;
		this.expirationTime = LocalDateTime.now().plusMinutes(30);
	}

	public boolean isVerified() {
		return verified && LocalDateTime.now().isBefore(expirationTime);
	}

	private void requireCode(String code) {
		if (this.verificationCode == null) {
			throw new RuntimeException();
		}
		if (this.verificationCode.isExpired()) {
			throw new RuntimeException();
		}
		if (this.verificationCode.hasNotMatched(code)) {
			throw new RuntimeException();
		}
	}
}
