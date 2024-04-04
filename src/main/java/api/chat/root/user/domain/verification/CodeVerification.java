package api.chat.root.user.domain.verification;

import java.time.LocalDateTime;

import api.chat.root.user.domain.VerificationCode;
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
	private VerificationToken verificationToken;

	public void verify(String code) {
		if (this.isExpired()) {
			throw new RuntimeException();
		}
		if (this.hasNotMatched(code)) {
			throw new RuntimeException();
		}

		this.verificationCode = null;
		this.verificationToken = VerificationToken.generate();
	}

	public boolean isVerified() {
		return this.verificationCode == null && this.verificationToken != null;
	}

	private boolean hasNotMatched(String credential) {
		if (this.verificationCode == null) {
			return false;
		}
		return this.verificationCode.code().equals(credential);
	}

	private boolean isExpired() {
		return LocalDateTime.now().isAfter(this.verificationCode.expirationTime());
	}
}
