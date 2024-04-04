package api.chat.root.user.domain.verification;

import java.time.LocalDateTime;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 4/1/24
 */

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class CodeVerification {
	private final VerificationCode verificationCode;
	private final VerificationToken verificationToken;

	public static CodeVerification generate() {
		return new CodeVerification(VerificationCode.generate(), null);
	}

	public CodeVerification verify(String code) {
		if (this.isExpired()) {
			throw new RuntimeException();
		}
		if (this.hasNotMatched(code)) {
			throw new RuntimeException();
		}

		return CodeVerification.verified();
	}

	public boolean isVerified() {
		return this.verificationCode == null && this.verificationToken != null;
	}

	private static CodeVerification verified() {
		return new CodeVerification(null, VerificationToken.generate());
	}

	private boolean hasNotMatched(String credential) {
		return this.verificationCode.code().equals(credential);
	}

	private boolean isExpired() {
		return LocalDateTime.now().isAfter(this.verificationCode.expirationTime());
	}
}
