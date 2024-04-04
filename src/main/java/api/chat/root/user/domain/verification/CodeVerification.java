package api.chat.root.user.domain.verification;

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
		requireCode(code);

		this.verificationCode = null;
		this.verificationToken = VerificationToken.generate();
	}

	public boolean isVerified() {
		return this.verificationCode == null && this.verificationToken != null;
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
