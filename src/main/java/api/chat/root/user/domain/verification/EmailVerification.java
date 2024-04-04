package api.chat.root.user.domain.verification;

import api.chat.root.user.domain.VerificationCode;
import lombok.Getter;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 4/1/24
 */

@Getter
public class EmailVerification extends CodeVerification {
	private final String emailAddress;

	protected EmailVerification(VerificationCode verificationCode, VerificationToken verificationToken,
		String emailAddress) {

		super(verificationCode, verificationToken);
		this.emailAddress = emailAddress;
	}

	public static EmailVerification generate(String emailAddress) {
		return new EmailVerification(VerificationCode.generate(), null, emailAddress);
	}
}
