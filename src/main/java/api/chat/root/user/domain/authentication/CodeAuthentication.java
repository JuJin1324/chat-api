package api.chat.root.user.domain.authentication;

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
public abstract class CodeAuthentication {
	private VerificationCode verificationCode;

	public AccessToken authenticate(String code) {
		requireCode(code);

		this.verificationCode = null;
		return AccessToken.generate();
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
