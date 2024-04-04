package api.chat.root.user.domain;

import api.chat.root.user.domain.verification.CodeVerification;
import api.chat.root.user.domain.verification.VerificationCode;
import api.chat.root.user.domain.verification.VerificationToken;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 3/31/24
 */

@AllArgsConstructor
@Getter
public class User {
	private final UserId id;
	private String nickname;
	private String profileImageUrl;
	private String phoneNumber;
	private String emailAddress;
	private final String username;
	private String password;
	private CodeVerification phoneVerification;
	private CodeVerification emailVerification;

	public VerificationCode generatePhoneCode() {
		this.phoneVerification = CodeVerification.generate();
		return this.phoneVerification.getVerificationCode();
	}

	public VerificationToken verifyPhone(String code) {
		this.phoneVerification = this.phoneVerification.verify(code);
		return this.phoneVerification.getVerificationToken();
	}

	public VerificationCode generateEmailCode() {
		this.emailVerification = CodeVerification.generate();
		return this.emailVerification.getVerificationCode();
	}

	public VerificationToken verifyEmail(String code) {
		this.emailVerification = this.emailVerification.verify(code);
		return this.emailVerification.getVerificationToken();
	}
}
